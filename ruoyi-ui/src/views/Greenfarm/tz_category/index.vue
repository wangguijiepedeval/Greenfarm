<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="店铺ID" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入店铺ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="父节点" prop="parentId">
        <el-input
          v-model="queryParams.parentId"
          placeholder="请输入父节点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品类目名称" prop="categoryName">
        <el-input
          v-model="queryParams.categoryName"
          placeholder="请输入产品类目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类目图标" prop="icon">
        <el-input
          v-model="queryParams.icon"
          placeholder="请输入类目图标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类目的显示图片" prop="pic">
        <el-input
          v-model="queryParams.pic"
          placeholder="请输入类目的显示图片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排序" prop="seq">
        <el-input
          v-model="queryParams.seq"
          placeholder="请输入排序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录时间" prop="recTime">
        <el-date-picker clearable
          v-model="queryParams.recTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择记录时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="分类层级" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入分类层级"
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
          v-hasPermi="['Greenfarm:tz_category:add']"
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
          v-hasPermi="['Greenfarm:tz_category:edit']"
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
          v-hasPermi="['Greenfarm:tz_category:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_category:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_categoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="类目ID" align="center" prop="categoryId" />
      <el-table-column label="店铺ID" align="center" prop="shopId" />
      <el-table-column label="父节点" align="center" prop="parentId" />
      <el-table-column label="产品类目名称" align="center" prop="categoryName" />
      <el-table-column label="类目图标" align="center" prop="icon" />
      <el-table-column label="类目的显示图片" align="center" prop="pic" />
      <el-table-column label="排序" align="center" prop="seq" />
      <el-table-column label="默认是1，表示正常状态,0为下线状态" align="center" prop="status" />
      <el-table-column label="记录时间" align="center" prop="recTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="分类层级" align="center" prop="grade" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_category:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_category:remove']"
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

    <!-- 添加或修改产品类目对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺ID" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺ID" />
        </el-form-item>
        <el-form-item label="父节点" prop="parentId">
          <el-input v-model="form.parentId" placeholder="请输入父节点" />
        </el-form-item>
        <el-form-item label="产品类目名称" prop="categoryName">
          <el-input v-model="form.categoryName" placeholder="请输入产品类目名称" />
        </el-form-item>
        <el-form-item label="类目图标" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入类目图标" />
        </el-form-item>
        <el-form-item label="类目的显示图片" prop="pic">
          <el-input v-model="form.pic" placeholder="请输入类目的显示图片" />
        </el-form-item>
        <el-form-item label="排序" prop="seq">
          <el-input v-model="form.seq" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="记录时间" prop="recTime">
          <el-date-picker clearable
            v-model="form.recTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="分类层级" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入分类层级" />
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
import { listTz_category, getTz_category, delTz_category, addTz_category, updateTz_category } from "@/api/Greenfarm/tz_category";

export default {
  name: "Tz_category",
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
      // 产品类目表格数据
      tz_categoryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        parentId: null,
        categoryName: null,
        icon: null,
        pic: null,
        seq: null,
        status: null,
        recTime: null,
        grade: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopId: [
          { required: true, message: "店铺ID不能为空", trigger: "blur" }
        ],
        parentId: [
          { required: true, message: "父节点不能为空", trigger: "blur" }
        ],
        categoryName: [
          { required: true, message: "产品类目名称不能为空", trigger: "blur" }
        ],
        seq: [
          { required: true, message: "排序不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "默认是1，表示正常状态,0为下线状态不能为空", trigger: "blur" }
        ],
        recTime: [
          { required: true, message: "记录时间不能为空", trigger: "blur" }
        ],
        grade: [
          { required: true, message: "分类层级不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询产品类目列表 */
    getList() {
      this.loading = true;
      listTz_category(this.queryParams).then(response => {
        this.tz_categoryList = response.rows;
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
        categoryId: null,
        shopId: null,
        parentId: null,
        categoryName: null,
        icon: null,
        pic: null,
        seq: null,
        status: 0,
        recTime: null,
        grade: null,
        updateTime: null
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
      this.ids = selection.map(item => item.categoryId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加产品类目";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const categoryId = row.categoryId || this.ids
      getTz_category(categoryId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改产品类目";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.categoryId != null) {
            updateTz_category(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_category(this.form).then(response => {
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
      const categoryIds = row.categoryId || this.ids;
      this.$modal.confirm('是否确认删除产品类目编号为"' + categoryIds + '"的数据项？').then(function() {
        return delTz_category(categoryIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_category/export', {
        ...this.queryParams
      }, `tz_category_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
