<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="品牌名称" prop="brandName">
        <el-input
          v-model="queryParams.brandName"
          placeholder="请输入品牌名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图片路径" prop="brandPic">
        <el-input
          v-model="queryParams.brandPic"
          placeholder="请输入图片路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="memo">
        <el-input
          v-model="queryParams.memo"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="顺序" prop="seq">
        <el-input
          v-model="queryParams.seq"
          placeholder="请输入顺序"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="简要描述" prop="brief">
        <el-input
          v-model="queryParams.brief"
          placeholder="请输入简要描述"
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
      <el-form-item label="品牌首字母" prop="firstChar">
        <el-input
          v-model="queryParams.firstChar"
          placeholder="请输入品牌首字母"
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
          v-hasPermi="['Greenfarm:tz_brand:add']"
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
          v-hasPermi="['Greenfarm:tz_brand:edit']"
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
          v-hasPermi="['Greenfarm:tz_brand:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_brand:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_brandList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="brandId" />
      <el-table-column label="品牌名称" align="center" prop="brandName" />
      <el-table-column label="图片路径" align="center" prop="brandPic" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="备注" align="center" prop="memo" />
      <el-table-column label="顺序" align="center" prop="seq" />
      <el-table-column label="默认是1，表示正常状态,0为下线状态" align="center" prop="status" />
      <el-table-column label="简要描述" align="center" prop="brief" />
      <el-table-column label="内容" align="center" prop="content" />
      <el-table-column label="记录时间" align="center" prop="recTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="品牌首字母" align="center" prop="firstChar" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_brand:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_brand:remove']"
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

    <!-- 添加或修改品牌对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="品牌名称" prop="brandName">
          <el-input v-model="form.brandName" placeholder="请输入品牌名称" />
        </el-form-item>
        <el-form-item label="图片路径" prop="brandPic">
          <el-input v-model="form.brandPic" placeholder="请输入图片路径" />
        </el-form-item>
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="备注" prop="memo">
          <el-input v-model="form.memo" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="顺序" prop="seq">
          <el-input v-model="form.seq" placeholder="请输入顺序" />
        </el-form-item>
        <el-form-item label="简要描述" prop="brief">
          <el-input v-model="form.brief" placeholder="请输入简要描述" />
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="记录时间" prop="recTime">
          <el-date-picker clearable
            v-model="form.recTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="品牌首字母" prop="firstChar">
          <el-input v-model="form.firstChar" placeholder="请输入品牌首字母" />
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
import { listTz_brand, getTz_brand, delTz_brand, addTz_brand, updateTz_brand } from "@/api/Greenfarm/tz_brand";

export default {
  name: "Tz_brand",
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
      // 品牌表格数据
      tz_brandList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        brandName: null,
        brandPic: null,
        userId: null,
        memo: null,
        seq: null,
        status: null,
        brief: null,
        content: null,
        recTime: null,
        firstChar: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        brandName: [
          { required: true, message: "品牌名称不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "默认是1，表示正常状态,0为下线状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询品牌列表 */
    getList() {
      this.loading = true;
      listTz_brand(this.queryParams).then(response => {
        this.tz_brandList = response.rows;
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
        brandId: null,
        brandName: null,
        brandPic: null,
        userId: null,
        memo: null,
        seq: null,
        status: 0,
        brief: null,
        content: null,
        recTime: null,
        updateTime: null,
        firstChar: null
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
      this.ids = selection.map(item => item.brandId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加品牌";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const brandId = row.brandId || this.ids
      getTz_brand(brandId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改品牌";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.brandId != null) {
            updateTz_brand(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_brand(this.form).then(response => {
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
      const brandIds = row.brandId || this.ids;
      this.$modal.confirm('是否确认删除品牌编号为"' + brandIds + '"的数据项？').then(function() {
        return delTz_brand(brandIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_brand/export', {
        ...this.queryParams
      }, `tz_brand_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
