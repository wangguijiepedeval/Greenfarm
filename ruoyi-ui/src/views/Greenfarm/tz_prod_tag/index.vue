<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="分组标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入分组标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺Id" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入店铺Id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="默认类型(0:商家自定义,1:系统默认)" prop="isDefault">
        <el-input
          v-model="queryParams.isDefault"
          placeholder="请输入默认类型(0:商家自定义,1:系统默认)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品数量" prop="prodCount">
        <el-input
          v-model="queryParams.prodCount"
          placeholder="请输入商品数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="列表样式(0:一列一个,1:一列两个,2:一列三个)" prop="style">
        <el-input
          v-model="queryParams.style"
          placeholder="请输入列表样式(0:一列一个,1:一列两个,2:一列三个)"
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
      <el-form-item label="删除时间" prop="deleteTime">
        <el-date-picker clearable
          v-model="queryParams.deleteTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择删除时间">
        </el-date-picker>
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
          v-hasPermi="['Greenfarm:tz_prod_tag:add']"
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
          v-hasPermi="['Greenfarm:tz_prod_tag:edit']"
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
          v-hasPermi="['Greenfarm:tz_prod_tag:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_prod_tag:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_prod_tagList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="分组标签id" align="center" prop="id" />
      <el-table-column label="分组标题" align="center" prop="title" />
      <el-table-column label="店铺Id" align="center" prop="shopId" />
      <el-table-column label="状态(1为正常,0为删除)" align="center" prop="status" />
      <el-table-column label="默认类型(0:商家自定义,1:系统默认)" align="center" prop="isDefault" />
      <el-table-column label="商品数量" align="center" prop="prodCount" />
      <el-table-column label="列表样式(0:一列一个,1:一列两个,2:一列三个)" align="center" prop="style" />
      <el-table-column label="排序" align="center" prop="seq" />
      <el-table-column label="删除时间" align="center" prop="deleteTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deleteTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_prod_tag:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_prod_tag:remove']"
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

    <!-- 添加或修改商品分组对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="分组标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入分组标题" />
        </el-form-item>
        <el-form-item label="店铺Id" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺Id" />
        </el-form-item>
        <el-form-item label="默认类型(0:商家自定义,1:系统默认)" prop="isDefault">
          <el-input v-model="form.isDefault" placeholder="请输入默认类型(0:商家自定义,1:系统默认)" />
        </el-form-item>
        <el-form-item label="商品数量" prop="prodCount">
          <el-input v-model="form.prodCount" placeholder="请输入商品数量" />
        </el-form-item>
        <el-form-item label="列表样式(0:一列一个,1:一列两个,2:一列三个)" prop="style">
          <el-input v-model="form.style" placeholder="请输入列表样式(0:一列一个,1:一列两个,2:一列三个)" />
        </el-form-item>
        <el-form-item label="排序" prop="seq">
          <el-input v-model="form.seq" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="删除时间" prop="deleteTime">
          <el-date-picker clearable
            v-model="form.deleteTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择删除时间">
          </el-date-picker>
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
import { listTz_prod_tag, getTz_prod_tag, delTz_prod_tag, addTz_prod_tag, updateTz_prod_tag } from "@/api/Greenfarm/tz_prod_tag";

export default {
  name: "Tz_prod_tag",
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
      // 商品分组表格数据
      tz_prod_tagList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        shopId: null,
        status: null,
        isDefault: null,
        prodCount: null,
        style: null,
        seq: null,
        deleteTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品分组列表 */
    getList() {
      this.loading = true;
      listTz_prod_tag(this.queryParams).then(response => {
        this.tz_prod_tagList = response.rows;
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
        id: null,
        title: null,
        shopId: null,
        status: 0,
        isDefault: null,
        prodCount: null,
        style: null,
        seq: null,
        createTime: null,
        updateTime: null,
        deleteTime: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品分组";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTz_prod_tag(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品分组";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTz_prod_tag(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_prod_tag(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除商品分组编号为"' + ids + '"的数据项？').then(function() {
        return delTz_prod_tag(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_prod_tag/export', {
        ...this.queryParams
      }, `tz_prod_tag_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
