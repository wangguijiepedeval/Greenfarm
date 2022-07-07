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
      <el-form-item label="订单ID" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入订单ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单流水号" prop="orderNumber">
        <el-input
          v-model="queryParams.orderNumber"
          placeholder="请输入订单流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单总金额" prop="orderAmount">
        <el-input
          v-model="queryParams.orderAmount"
          placeholder="请输入订单总金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单项ID 全部退款是0" prop="orderItemId">
        <el-input
          v-model="queryParams.orderItemId"
          placeholder="请输入订单项ID 全部退款是0"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退款编号" prop="refundSn">
        <el-input
          v-model="queryParams.refundSn"
          placeholder="请输入退款编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单支付流水号" prop="flowTradeNo">
        <el-input
          v-model="queryParams.flowTradeNo"
          placeholder="请输入订单支付流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第三方退款单号(微信退款单号)" prop="outRefundNo">
        <el-input
          v-model="queryParams.outRefundNo"
          placeholder="请输入第三方退款单号(微信退款单号)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单支付名称" prop="payTypeName">
        <el-input
          v-model="queryParams.payTypeName"
          placeholder="请输入订单支付名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="买家ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入买家ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货数量" prop="goodsNum">
        <el-input
          v-model="queryParams.goodsNum"
          placeholder="请输入退货数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退款金额" prop="refundAmount">
        <el-input
          v-model="queryParams.refundAmount"
          placeholder="请输入退款金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理状态:1为待审核,2为同意,3为不同意" prop="refundSts">
        <el-input
          v-model="queryParams.refundSts"
          placeholder="请输入处理状态:1为待审核,2为同意,3为不同意"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败" prop="returnMoneySts">
        <el-input
          v-model="queryParams.returnMoneySts"
          placeholder="请输入处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请时间" prop="applyTime">
        <el-date-picker clearable
          v-model="queryParams.applyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择申请时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="卖家处理时间" prop="handelTime">
        <el-date-picker clearable
          v-model="queryParams.handelTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择卖家处理时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="退款时间" prop="refundTime">
        <el-date-picker clearable
          v-model="queryParams.refundTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择退款时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="文件凭证json" prop="photoFiles">
        <el-input
          v-model="queryParams.photoFiles"
          placeholder="请输入文件凭证json"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请原因" prop="buyerMsg">
        <el-input
          v-model="queryParams.buyerMsg"
          placeholder="请输入申请原因"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="卖家备注" prop="sellerMsg">
        <el-input
          v-model="queryParams.sellerMsg"
          placeholder="请输入卖家备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流公司名称" prop="expressName">
        <el-input
          v-model="queryParams.expressName"
          placeholder="请输入物流公司名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流单号" prop="expressNo">
        <el-input
          v-model="queryParams.expressNo"
          placeholder="请输入物流单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货时间" prop="shipTime">
        <el-date-picker clearable
          v-model="queryParams.shipTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="收货时间" prop="receiveTime">
        <el-date-picker clearable
          v-model="queryParams.receiveTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择收货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="收货备注" prop="receiveMessage">
        <el-input
          v-model="queryParams.receiveMessage"
          placeholder="请输入收货备注"
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
          v-hasPermi="['Greenfarm:tz_order_refund:add']"
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
          v-hasPermi="['Greenfarm:tz_order_refund:edit']"
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
          v-hasPermi="['Greenfarm:tz_order_refund:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_order_refund:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_order_refundList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录ID" align="center" prop="refundId" />
      <el-table-column label="店铺ID" align="center" prop="shopId" />
      <el-table-column label="订单ID" align="center" prop="orderId" />
      <el-table-column label="订单流水号" align="center" prop="orderNumber" />
      <el-table-column label="订单总金额" align="center" prop="orderAmount" />
      <el-table-column label="订单项ID 全部退款是0" align="center" prop="orderItemId" />
      <el-table-column label="退款编号" align="center" prop="refundSn" />
      <el-table-column label="订单支付流水号" align="center" prop="flowTradeNo" />
      <el-table-column label="第三方退款单号(微信退款单号)" align="center" prop="outRefundNo" />
      <el-table-column label="订单支付方式 1 微信支付 2 支付宝" align="center" prop="payType" />
      <el-table-column label="订单支付名称" align="center" prop="payTypeName" />
      <el-table-column label="买家ID" align="center" prop="userId" />
      <el-table-column label="退货数量" align="center" prop="goodsNum" />
      <el-table-column label="退款金额" align="center" prop="refundAmount" />
      <el-table-column label="申请类型:1,仅退款,2退款退货" align="center" prop="applyType" />
      <el-table-column label="处理状态:1为待审核,2为同意,3为不同意" align="center" prop="refundSts" />
      <el-table-column label="处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败" align="center" prop="returnMoneySts" />
      <el-table-column label="申请时间" align="center" prop="applyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.applyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="卖家处理时间" align="center" prop="handelTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.handelTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="退款时间" align="center" prop="refundTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.refundTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="文件凭证json" align="center" prop="photoFiles" />
      <el-table-column label="申请原因" align="center" prop="buyerMsg" />
      <el-table-column label="卖家备注" align="center" prop="sellerMsg" />
      <el-table-column label="物流公司名称" align="center" prop="expressName" />
      <el-table-column label="物流单号" align="center" prop="expressNo" />
      <el-table-column label="发货时间" align="center" prop="shipTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.shipTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="收货时间" align="center" prop="receiveTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.receiveTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="收货备注" align="center" prop="receiveMessage" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_order_refund:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_order_refund:remove']"
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

    <!-- 添加或修改记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺ID" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺ID" />
        </el-form-item>
        <el-form-item label="订单ID" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入订单ID" />
        </el-form-item>
        <el-form-item label="订单流水号" prop="orderNumber">
          <el-input v-model="form.orderNumber" placeholder="请输入订单流水号" />
        </el-form-item>
        <el-form-item label="订单总金额" prop="orderAmount">
          <el-input v-model="form.orderAmount" placeholder="请输入订单总金额" />
        </el-form-item>
        <el-form-item label="订单项ID 全部退款是0" prop="orderItemId">
          <el-input v-model="form.orderItemId" placeholder="请输入订单项ID 全部退款是0" />
        </el-form-item>
        <el-form-item label="退款编号" prop="refundSn">
          <el-input v-model="form.refundSn" placeholder="请输入退款编号" />
        </el-form-item>
        <el-form-item label="订单支付流水号" prop="flowTradeNo">
          <el-input v-model="form.flowTradeNo" placeholder="请输入订单支付流水号" />
        </el-form-item>
        <el-form-item label="第三方退款单号(微信退款单号)" prop="outRefundNo">
          <el-input v-model="form.outRefundNo" placeholder="请输入第三方退款单号(微信退款单号)" />
        </el-form-item>
        <el-form-item label="订单支付名称" prop="payTypeName">
          <el-input v-model="form.payTypeName" placeholder="请输入订单支付名称" />
        </el-form-item>
        <el-form-item label="买家ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入买家ID" />
        </el-form-item>
        <el-form-item label="退货数量" prop="goodsNum">
          <el-input v-model="form.goodsNum" placeholder="请输入退货数量" />
        </el-form-item>
        <el-form-item label="退款金额" prop="refundAmount">
          <el-input v-model="form.refundAmount" placeholder="请输入退款金额" />
        </el-form-item>
        <el-form-item label="处理状态:1为待审核,2为同意,3为不同意" prop="refundSts">
          <el-input v-model="form.refundSts" placeholder="请输入处理状态:1为待审核,2为同意,3为不同意" />
        </el-form-item>
        <el-form-item label="处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败" prop="returnMoneySts">
          <el-input v-model="form.returnMoneySts" placeholder="请输入处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败" />
        </el-form-item>
        <el-form-item label="申请时间" prop="applyTime">
          <el-date-picker clearable
            v-model="form.applyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择申请时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="卖家处理时间" prop="handelTime">
          <el-date-picker clearable
            v-model="form.handelTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择卖家处理时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="退款时间" prop="refundTime">
          <el-date-picker clearable
            v-model="form.refundTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择退款时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="文件凭证json" prop="photoFiles">
          <el-input v-model="form.photoFiles" placeholder="请输入文件凭证json" />
        </el-form-item>
        <el-form-item label="申请原因" prop="buyerMsg">
          <el-input v-model="form.buyerMsg" placeholder="请输入申请原因" />
        </el-form-item>
        <el-form-item label="卖家备注" prop="sellerMsg">
          <el-input v-model="form.sellerMsg" placeholder="请输入卖家备注" />
        </el-form-item>
        <el-form-item label="物流公司名称" prop="expressName">
          <el-input v-model="form.expressName" placeholder="请输入物流公司名称" />
        </el-form-item>
        <el-form-item label="物流单号" prop="expressNo">
          <el-input v-model="form.expressNo" placeholder="请输入物流单号" />
        </el-form-item>
        <el-form-item label="发货时间" prop="shipTime">
          <el-date-picker clearable
            v-model="form.shipTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="收货时间" prop="receiveTime">
          <el-date-picker clearable
            v-model="form.receiveTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择收货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="收货备注" prop="receiveMessage">
          <el-input v-model="form.receiveMessage" placeholder="请输入收货备注" />
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
import { listTz_order_refund, getTz_order_refund, delTz_order_refund, addTz_order_refund, updateTz_order_refund } from "@/api/Greenfarm/tz_order_refund";

export default {
  name: "Tz_order_refund",
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
      // 记录表格数据
      tz_order_refundList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        orderId: null,
        orderNumber: null,
        orderAmount: null,
        orderItemId: null,
        refundSn: null,
        flowTradeNo: null,
        outRefundNo: null,
        payType: null,
        payTypeName: null,
        userId: null,
        goodsNum: null,
        refundAmount: null,
        applyType: null,
        refundSts: null,
        returnMoneySts: null,
        applyTime: null,
        handelTime: null,
        refundTime: null,
        photoFiles: null,
        buyerMsg: null,
        sellerMsg: null,
        expressName: null,
        expressNo: null,
        shipTime: null,
        receiveTime: null,
        receiveMessage: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopId: [
          { required: true, message: "店铺ID不能为空", trigger: "blur" }
        ],
        orderId: [
          { required: true, message: "订单ID不能为空", trigger: "blur" }
        ],
        orderNumber: [
          { required: true, message: "订单流水号不能为空", trigger: "blur" }
        ],
        orderAmount: [
          { required: true, message: "订单总金额不能为空", trigger: "blur" }
        ],
        orderItemId: [
          { required: true, message: "订单项ID 全部退款是0不能为空", trigger: "blur" }
        ],
        refundSn: [
          { required: true, message: "退款编号不能为空", trigger: "blur" }
        ],
        flowTradeNo: [
          { required: true, message: "订单支付流水号不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "买家ID不能为空", trigger: "blur" }
        ],
        refundAmount: [
          { required: true, message: "退款金额不能为空", trigger: "blur" }
        ],
        applyType: [
          { required: true, message: "申请类型:1,仅退款,2退款退货不能为空", trigger: "change" }
        ],
        refundSts: [
          { required: true, message: "处理状态:1为待审核,2为同意,3为不同意不能为空", trigger: "blur" }
        ],
        returnMoneySts: [
          { required: true, message: "处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败不能为空", trigger: "blur" }
        ],
        applyTime: [
          { required: true, message: "申请时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询记录列表 */
    getList() {
      this.loading = true;
      listTz_order_refund(this.queryParams).then(response => {
        this.tz_order_refundList = response.rows;
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
        refundId: null,
        shopId: null,
        orderId: null,
        orderNumber: null,
        orderAmount: null,
        orderItemId: null,
        refundSn: null,
        flowTradeNo: null,
        outRefundNo: null,
        payType: null,
        payTypeName: null,
        userId: null,
        goodsNum: null,
        refundAmount: null,
        applyType: null,
        refundSts: null,
        returnMoneySts: null,
        applyTime: null,
        handelTime: null,
        refundTime: null,
        photoFiles: null,
        buyerMsg: null,
        sellerMsg: null,
        expressName: null,
        expressNo: null,
        shipTime: null,
        receiveTime: null,
        receiveMessage: null
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
      this.ids = selection.map(item => item.refundId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const refundId = row.refundId || this.ids
      getTz_order_refund(refundId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.refundId != null) {
            updateTz_order_refund(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_order_refund(this.form).then(response => {
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
      const refundIds = row.refundId || this.ids;
      this.$modal.confirm('是否确认删除记录编号为"' + refundIds + '"的数据项？').then(function() {
        return delTz_order_refund(refundIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_order_refund/export', {
        ...this.queryParams
      }, `tz_order_refund_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
