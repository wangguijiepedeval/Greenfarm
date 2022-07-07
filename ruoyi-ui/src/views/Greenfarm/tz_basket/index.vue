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
      <el-form-item label="产品ID" prop="prodId">
        <el-input
          v-model="queryParams.prodId"
          placeholder="请输入产品ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="SkuID" prop="skuId">
        <el-input
          v-model="queryParams.skuId"
          placeholder="请输入SkuID"
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
      <el-form-item label="购物车产品个数" prop="basketCount">
        <el-input
          v-model="queryParams.basketCount"
          placeholder="请输入购物车产品个数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="购物时间" prop="basketDate">
        <el-date-picker clearable
          v-model="queryParams.basketDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择购物时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="满减活动ID" prop="discountId">
        <el-input
          v-model="queryParams.discountId"
          placeholder="请输入满减活动ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分销推广人卡号" prop="distributionCardNo">
        <el-input
          v-model="queryParams.distributionCardNo"
          placeholder="请输入分销推广人卡号"
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
          v-hasPermi="['Greenfarm:tz_basket:add']"
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
          v-hasPermi="['Greenfarm:tz_basket:edit']"
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
          v-hasPermi="['Greenfarm:tz_basket:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_basket:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_basketList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="basketId" />
      <el-table-column label="店铺ID" align="center" prop="shopId" />
      <el-table-column label="产品ID" align="center" prop="prodId" />
      <el-table-column label="SkuID" align="center" prop="skuId" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="购物车产品个数" align="center" prop="basketCount" />
      <el-table-column label="购物时间" align="center" prop="basketDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.basketDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="满减活动ID" align="center" prop="discountId" />
      <el-table-column label="分销推广人卡号" align="center" prop="distributionCardNo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_basket:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_basket:remove']"
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

    <!-- 添加或修改购物车对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺ID" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺ID" />
        </el-form-item>
        <el-form-item label="产品ID" prop="prodId">
          <el-input v-model="form.prodId" placeholder="请输入产品ID" />
        </el-form-item>
        <el-form-item label="SkuID" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入SkuID" />
        </el-form-item>
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="购物车产品个数" prop="basketCount">
          <el-input v-model="form.basketCount" placeholder="请输入购物车产品个数" />
        </el-form-item>
        <el-form-item label="购物时间" prop="basketDate">
          <el-date-picker clearable
            v-model="form.basketDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择购物时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="满减活动ID" prop="discountId">
          <el-input v-model="form.discountId" placeholder="请输入满减活动ID" />
        </el-form-item>
        <el-form-item label="分销推广人卡号" prop="distributionCardNo">
          <el-input v-model="form.distributionCardNo" placeholder="请输入分销推广人卡号" />
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
import { listTz_basket, getTz_basket, delTz_basket, addTz_basket, updateTz_basket } from "@/api/Greenfarm/tz_basket";

export default {
  name: "Tz_basket",
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
      // 购物车表格数据
      tz_basketList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        prodId: null,
        skuId: null,
        userId: null,
        basketCount: null,
        basketDate: null,
        discountId: null,
        distributionCardNo: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopId: [
          { required: true, message: "店铺ID不能为空", trigger: "blur" }
        ],
        prodId: [
          { required: true, message: "产品ID不能为空", trigger: "blur" }
        ],
        skuId: [
          { required: true, message: "SkuID不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        basketCount: [
          { required: true, message: "购物车产品个数不能为空", trigger: "blur" }
        ],
        basketDate: [
          { required: true, message: "购物时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询购物车列表 */
    getList() {
      this.loading = true;
      listTz_basket(this.queryParams).then(response => {
        this.tz_basketList = response.rows;
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
        basketId: null,
        shopId: null,
        prodId: null,
        skuId: null,
        userId: null,
        basketCount: null,
        basketDate: null,
        discountId: null,
        distributionCardNo: null
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
      this.ids = selection.map(item => item.basketId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加购物车";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const basketId = row.basketId || this.ids
      getTz_basket(basketId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改购物车";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.basketId != null) {
            updateTz_basket(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_basket(this.form).then(response => {
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
      const basketIds = row.basketId || this.ids;
      this.$modal.confirm('是否确认删除购物车编号为"' + basketIds + '"的数据项？').then(function() {
        return delTz_basket(basketIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_basket/export', {
        ...this.queryParams
      }, `tz_basket_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
