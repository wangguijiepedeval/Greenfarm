<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="prodName">
        <el-input
          v-model="queryParams.prodName"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺id" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入店铺id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原价" prop="oriPrice">
        <el-input
          v-model="queryParams.oriPrice"
          placeholder="请输入原价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现价" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入现价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品主图" prop="pic">
        <el-input
          v-model="queryParams.pic"
          placeholder="请输入商品主图"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品分类" prop="categoryId">
        <el-input
          v-model="queryParams.categoryId"
          placeholder="请输入商品分类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销量" prop="soldNum">
        <el-input
          v-model="queryParams.soldNum"
          placeholder="请输入销量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总库存" prop="totalStocks">
        <el-input
          v-model="queryParams.totalStocks"
          placeholder="请输入总库存"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运费模板id" prop="deliveryTemplateId">
        <el-input
          v-model="queryParams.deliveryTemplateId"
          placeholder="请输入运费模板id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上架时间" prop="putawayTime">
        <el-date-picker clearable
          v-model="queryParams.putawayTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择上架时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="版本 乐观锁" prop="version">
        <el-input
          v-model="queryParams.version"
          placeholder="请输入版本 乐观锁"
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
          v-hasPermi="['Greenfarm:tz_prod:add']"
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
          v-hasPermi="['Greenfarm:tz_prod:edit']"
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
          v-hasPermi="['Greenfarm:tz_prod:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_prod:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_prodList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="产品ID" align="center" prop="prodId" />
      <el-table-column label="商品名称" align="center" prop="prodName" />
      <el-table-column label="店铺id" align="center" prop="shopId" />
      <el-table-column label="原价" align="center" prop="oriPrice" />
      <el-table-column label="现价" align="center" prop="price" />
      <el-table-column label="简要描述,卖点等" align="center" prop="brief" />
      <el-table-column label="详细描述" align="center" prop="content" />
      <el-table-column label="商品主图" align="center" prop="pic" />
      <el-table-column label="商品图片，以,分割" align="center" prop="imgs" />
      <el-table-column label="默认是1，表示正常状态, -1表示删除, 0下架" align="center" prop="status" />
      <el-table-column label="商品分类" align="center" prop="categoryId" />
      <el-table-column label="销量" align="center" prop="soldNum" />
      <el-table-column label="总库存" align="center" prop="totalStocks" />
      <el-table-column label="配送方式json见TransportModeVO" align="center" prop="deliveryMode" />
      <el-table-column label="运费模板id" align="center" prop="deliveryTemplateId" />
      <el-table-column label="上架时间" align="center" prop="putawayTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.putawayTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="版本 乐观锁" align="center" prop="version" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_prod:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_prod:remove']"
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

    <!-- 添加或修改商品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品名称" prop="prodName">
          <el-input v-model="form.prodName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="店铺id" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺id" />
        </el-form-item>
        <el-form-item label="原价" prop="oriPrice">
          <el-input v-model="form.oriPrice" placeholder="请输入原价" />
        </el-form-item>
        <el-form-item label="现价" prop="price">
          <el-input v-model="form.price" placeholder="请输入现价" />
        </el-form-item>
        <el-form-item label="简要描述,卖点等" prop="brief">
          <el-input v-model="form.brief" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="详细描述">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="商品主图" prop="pic">
          <el-input v-model="form.pic" placeholder="请输入商品主图" />
        </el-form-item>
        <el-form-item label="商品图片，以,分割" prop="imgs">
          <el-input v-model="form.imgs" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品分类" prop="categoryId">
          <el-input v-model="form.categoryId" placeholder="请输入商品分类" />
        </el-form-item>
        <el-form-item label="销量" prop="soldNum">
          <el-input v-model="form.soldNum" placeholder="请输入销量" />
        </el-form-item>
        <el-form-item label="总库存" prop="totalStocks">
          <el-input v-model="form.totalStocks" placeholder="请输入总库存" />
        </el-form-item>
        <el-form-item label="运费模板id" prop="deliveryTemplateId">
          <el-input v-model="form.deliveryTemplateId" placeholder="请输入运费模板id" />
        </el-form-item>
        <el-form-item label="上架时间" prop="putawayTime">
          <el-date-picker clearable
            v-model="form.putawayTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上架时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="版本 乐观锁" prop="version">
          <el-input v-model="form.version" placeholder="请输入版本 乐观锁" />
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
import { listTz_prod, getTz_prod, delTz_prod, addTz_prod, updateTz_prod } from "@/api/Greenfarm/tz_prod";

export default {
  name: "Tz_prod",
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
      // 商品表格数据
      tz_prodList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        prodName: null,
        shopId: null,
        oriPrice: null,
        price: null,
        brief: null,
        content: null,
        pic: null,
        imgs: null,
        status: null,
        categoryId: null,
        soldNum: null,
        totalStocks: null,
        deliveryMode: null,
        deliveryTemplateId: null,
        putawayTime: null,
        version: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        prodName: [
          { required: true, message: "商品名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品列表 */
    getList() {
      this.loading = true;
      listTz_prod(this.queryParams).then(response => {
        this.tz_prodList = response.rows;
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
        prodId: null,
        prodName: null,
        shopId: null,
        oriPrice: null,
        price: null,
        brief: null,
        content: null,
        pic: null,
        imgs: null,
        status: 0,
        categoryId: null,
        soldNum: null,
        totalStocks: null,
        deliveryMode: null,
        deliveryTemplateId: null,
        createTime: null,
        updateTime: null,
        putawayTime: null,
        version: null
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
      this.ids = selection.map(item => item.prodId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const prodId = row.prodId || this.ids
      getTz_prod(prodId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.prodId != null) {
            updateTz_prod(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_prod(this.form).then(response => {
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
      const prodIds = row.prodId || this.ids;
      this.$modal.confirm('是否确认删除商品编号为"' + prodIds + '"的数据项？').then(function() {
        return delTz_prod(prodIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_prod/export', {
        ...this.queryParams
      }, `tz_prod_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
