<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="店铺ID 0为全局热搜" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入店铺ID 0为全局热搜"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="录入时间" prop="recDate">
        <el-date-picker clearable
          v-model="queryParams.recDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择录入时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="顺序" prop="seq">
        <el-input
          v-model="queryParams.seq"
          placeholder="请输入顺序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="热搜标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入热搜标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['Greenfarm:tz_hot_search:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['Greenfarm:tz_hot_search:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['Greenfarm:tz_hot_search:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_hot_search:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_hot_searchList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="hotSearchId" />
      <el-table-column label="店铺ID 0为全局热搜" align="center" prop="shopId" />
      <el-table-column label="内容" align="center" prop="content" />
      <el-table-column label="录入时间" align="center" prop="recDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="顺序" align="center" prop="seq" />
      <el-table-column label="状态 0下线 1上线" align="center" prop="status" />
      <el-table-column label="热搜标题" align="center" prop="title" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_hot_search:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_hot_search:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改热搜对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺ID 0为全局热搜" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺ID 0为全局热搜" />
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="录入时间" prop="recDate">
          <el-date-picker clearable
            v-model="form.recDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择录入时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="顺序" prop="seq">
          <el-input v-model="form.seq" placeholder="请输入顺序" />
        </el-form-item>
        <el-form-item label="热搜标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入热搜标题" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTz_hot_search, getTz_hot_search, delTz_hot_search, addTz_hot_search, updateTz_hot_search } from "@/api/Greenfarm/tz_hot_search";

export default {
  name: "Tz_hot_search",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 热搜表格数据
      tz_hot_searchList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        content: null,
        recDate: null,
        seq: null,
        status: null,
        title: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        content: [
          { required: true, message: "内容不能为空", trigger: "blur" }
        ],
        recDate: [
          { required: true, message: "录入时间不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态 0下线 1上线不能为空", trigger: "blur" }
        ],
        title: [
          { required: true, message: "热搜标题不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询热搜列表 */
    getList() {
      this.loading = true;
      listTz_hot_search(this.queryParams).then(response => {
        this.tz_hot_searchList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        hotSearchId: null,
        shopId: null,
        content: null,
        recDate: null,
        seq: null,
        status: 0,
        title: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.hotSearchId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加热搜";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const hotSearchId = row.hotSearchId || this.ids
      getTz_hot_search(hotSearchId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改热搜";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.hotSearchId != null) {
            updateTz_hot_search(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_hot_search(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const hotSearchIds = row.hotSearchId || this.ids;
      this.$modal.confirm('是否确认删除热搜编号为"' + hotSearchIds + '"的数据项？').then(function() {
        return delTz_hot_search(hotSearchIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_hot_search/export', {
        ...this.queryParams
      }, `tz_hot_search_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
