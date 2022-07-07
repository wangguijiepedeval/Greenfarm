<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="店铺id" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入店铺id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单order_number" prop="orderNumber">
        <el-input
          v-model="queryParams.orderNumber"
          placeholder="请输入订单order_number"
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
      <el-form-item label="产品SkuID" prop="skuId">
        <el-input
          v-model="queryParams.skuId"
          placeholder="请输入产品SkuID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="购物车产品个数" prop="prodCount">
        <el-input
          v-model="queryParams.prodCount"
          placeholder="请输入购物车产品个数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品名称" prop="prodName">
        <el-input
          v-model="queryParams.prodName"
          placeholder="请输入产品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="sku名称" prop="skuName">
        <el-input
          v-model="queryParams.skuName"
          placeholder="请输入sku名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品主图片路径" prop="pic">
        <el-input
          v-model="queryParams.pic"
          placeholder="请输入产品主图片路径"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入产品价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户Id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户Id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品总金额" prop="productTotalAmount">
        <el-input
          v-model="queryParams.productTotalAmount"
          placeholder="请输入商品总金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="购物时间" prop="recTime">
        <el-date-picker clearable
          v-model="queryParams.recTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择购物时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="评论状态： 0 未评价  1 已评价" prop="commSts">
        <el-input
          v-model="queryParams.commSts"
          placeholder="请输入评论状态： 0 未评价  1 已评价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="推广员使用的推销卡号" prop="distributionCardNo">
        <el-input
          v-model="queryParams.distributionCardNo"
          placeholder="请输入推广员使用的推销卡号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="加入购物车时间" prop="basketDate">
        <el-date-picker clearable
          v-model="queryParams.basketDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择加入购物车时间">
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
          v-hasPermi="['Greenfarm:tz_order_item:add']"
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
          v-hasPermi="['Greenfarm:tz_order_item:edit']"
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
          v-hasPermi="['Greenfarm:tz_order_item:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_order_item:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_order_itemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单项ID" align="center" prop="orderItemId" />
      <el-table-column label="店铺id" align="center" prop="shopId" />
      <el-table-column label="订单order_number" align="center" prop="orderNumber" />
      <el-table-column label="产品ID" align="center" prop="prodId" />
      <el-table-column label="产品SkuID" align="center" prop="skuId" />
      <el-table-column label="购物车产品个数" align="center" prop="prodCount" />
      <el-table-column label="产品名称" align="center" prop="prodName" />
      <el-table-column label="sku名称" align="center" prop="skuName" />
      <el-table-column label="产品主图片路径" align="center" prop="pic" />
      <el-table-column label="产品价格" align="center" prop="price" />
      <el-table-column label="用户Id" align="center" prop="userId" />
      <el-table-column label="商品总金额" align="center" prop="productTotalAmount" />
      <el-table-column label="购物时间" align="center" prop="recTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评论状态： 0 未评价  1 已评价" align="center" prop="commSts" />
      <el-table-column label="推广员使用的推销卡号" align="center" prop="distributionCardNo" />
      <el-table-column label="加入购物车时间" align="center" prop="basketDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.basketDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_order_item:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_order_item:remove']"
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

    <!-- 添加或修改订单项对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺id" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺id" />
        </el-form-item>
        <el-form-item label="订单order_number" prop="orderNumber">
          <el-input v-model="form.orderNumber" placeholder="请输入订单order_number" />
        </el-form-item>
        <el-form-item label="产品ID" prop="prodId">
          <el-input v-model="form.prodId" placeholder="请输入产品ID" />
        </el-form-item>
        <el-form-item label="产品SkuID" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入产品SkuID" />
        </el-form-item>
        <el-form-item label="购物车产品个数" prop="prodCount">
          <el-input v-model="form.prodCount" placeholder="请输入购物车产品个数" />
        </el-form-item>
        <el-form-item label="产品名称" prop="prodName">
          <el-input v-model="form.prodName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="sku名称" prop="skuName">
          <el-input v-model="form.skuName" placeholder="请输入sku名称" />
        </el-form-item>
        <el-form-item label="产品主图片路径" prop="pic">
          <el-input v-model="form.pic" placeholder="请输入产品主图片路径" />
        </el-form-item>
        <el-form-item label="产品价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入产品价格" />
        </el-form-item>
        <el-form-item label="用户Id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户Id" />
        </el-form-item>
        <el-form-item label="商品总金额" prop="productTotalAmount">
          <el-input v-model="form.productTotalAmount" placeholder="请输入商品总金额" />
        </el-form-item>
        <el-form-item label="购物时间" prop="recTime">
          <el-date-picker clearable
            v-model="form.recTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择购物时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评论状态： 0 未评价  1 已评价" prop="commSts">
          <el-input v-model="form.commSts" placeholder="请输入评论状态： 0 未评价  1 已评价" />
        </el-form-item>
        <el-form-item label="推广员使用的推销卡号" prop="distributionCardNo">
          <el-input v-model="form.distributionCardNo" placeholder="请输入推广员使用的推销卡号" />
        </el-form-item>
        <el-form-item label="加入购物车时间" prop="basketDate">
          <el-date-picker clearable
            v-model="form.basketDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择加入购物车时间">
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
import { listTz_order_item, getTz_order_item, delTz_order_item, addTz_order_item, updateTz_order_item } from "@/api/Greenfarm/tz_order_item";

export default {
  name: "Tz_order_item",
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
      // 订单项表格数据
      tz_order_itemList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        orderNumber: null,
        prodId: null,
        skuId: null,
        prodCount: null,
        prodName: null,
        skuName: null,
        pic: null,
        price: null,
        userId: null,
        productTotalAmount: null,
        recTime: null,
        commSts: null,
        distributionCardNo: null,
        basketDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopId: [
          { required: true, message: "店铺id不能为空", trigger: "blur" }
        ],
        orderNumber: [
          { required: true, message: "订单order_number不能为空", trigger: "blur" }
        ],
        prodId: [
          { required: true, message: "产品ID不能为空", trigger: "blur" }
        ],
        skuId: [
          { required: true, message: "产品SkuID不能为空", trigger: "blur" }
        ],
        prodCount: [
          { required: true, message: "购物车产品个数不能为空", trigger: "blur" }
        ],
        prodName: [
          { required: true, message: "产品名称不能为空", trigger: "blur" }
        ],
        pic: [
          { required: true, message: "产品主图片路径不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "产品价格不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户Id不能为空", trigger: "blur" }
        ],
        productTotalAmount: [
          { required: true, message: "商品总金额不能为空", trigger: "blur" }
        ],
        recTime: [
          { required: true, message: "购物时间不能为空", trigger: "blur" }
        ],
        commSts: [
          { required: true, message: "评论状态： 0 未评价  1 已评价不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单项列表 */
    getList() {
      this.loading = true;
      listTz_order_item(this.queryParams).then(response => {
        this.tz_order_itemList = response.rows;
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
        orderItemId: null,
        shopId: null,
        orderNumber: null,
        prodId: null,
        skuId: null,
        prodCount: null,
        prodName: null,
        skuName: null,
        pic: null,
        price: null,
        userId: null,
        productTotalAmount: null,
        recTime: null,
        commSts: null,
        distributionCardNo: null,
        basketDate: null
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
      this.ids = selection.map(item => item.orderItemId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单项";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orderItemId = row.orderItemId || this.ids
      getTz_order_item(orderItemId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单项";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orderItemId != null) {
            updateTz_order_item(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_order_item(this.form).then(response => {
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
      const orderItemIds = row.orderItemId || this.ids;
      this.$modal.confirm('是否确认删除订单项编号为"' + orderItemIds + '"的数据项？').then(function() {
        return delTz_order_item(orderItemIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_order_item/export', {
        ...this.queryParams
      }, `tz_order_item_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
