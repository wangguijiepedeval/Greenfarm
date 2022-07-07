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
      <el-form-item label="订购用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入订购用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订购流水号" prop="orderNumber">
        <el-input
          v-model="queryParams.orderNumber"
          placeholder="请输入订购流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总值" prop="total">
        <el-input
          v-model="queryParams.total"
          placeholder="请输入总值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际总值" prop="actualTotal">
        <el-input
          v-model="queryParams.actualTotal"
          placeholder="请输入实际总值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="配送方式ID" prop="dvyId">
        <el-input
          v-model="queryParams.dvyId"
          placeholder="请输入配送方式ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="物流单号" prop="dvyFlowId">
        <el-input
          v-model="queryParams.dvyFlowId"
          placeholder="请输入物流单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单运费" prop="freightAmount">
        <el-input
          v-model="queryParams.freightAmount"
          placeholder="请输入订单运费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户订单地址Id" prop="addrOrderId">
        <el-input
          v-model="queryParams.addrOrderId"
          placeholder="请输入用户订单地址Id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单商品总数" prop="productNums">
        <el-input
          v-model="queryParams.productNums"
          placeholder="请输入订单商品总数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款时间" prop="payTime">
        <el-date-picker clearable
          v-model="queryParams.payTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择付款时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="发货时间" prop="dvyTime">
        <el-date-picker clearable
          v-model="queryParams.dvyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="完成时间" prop="finallyTime">
        <el-date-picker clearable
          v-model="queryParams.finallyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择完成时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="取消时间" prop="cancelTime">
        <el-date-picker clearable
          v-model="queryParams.cancelTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择取消时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否已经支付，1：已经支付过，0：，没有支付过" prop="isPayed">
        <el-input
          v-model="queryParams.isPayed"
          placeholder="请输入是否已经支付，1：已经支付过，0：，没有支付过"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0:默认,1:在处理,2:处理完成" prop="refundSts">
        <el-input
          v-model="queryParams.refundSts"
          placeholder="请输入0:默认,1:在处理,2:处理完成"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="优惠总额" prop="reduceAmount">
        <el-input
          v-model="queryParams.reduceAmount"
          placeholder="请输入优惠总额"
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
          v-hasPermi="['Greenfarm:tz_order:add']"
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
          v-hasPermi="['Greenfarm:tz_order:edit']"
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
          v-hasPermi="['Greenfarm:tz_order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['Greenfarm:tz_order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tz_orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单ID" align="center" prop="orderId" />
      <el-table-column label="店铺id" align="center" prop="shopId" />
      <el-table-column label="产品名称,多个产品将会以逗号隔开" align="center" prop="prodName" />
      <el-table-column label="订购用户ID" align="center" prop="userId" />
      <el-table-column label="订购流水号" align="center" prop="orderNumber" />
      <el-table-column label="总值" align="center" prop="total" />
      <el-table-column label="实际总值" align="center" prop="actualTotal" />
      <el-table-column label="支付方式 0 手动代付 1 微信支付 2 支付宝" align="center" prop="payType" />
      <el-table-column label="订单备注" align="center" prop="remarks" />
      <el-table-column label="订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败" align="center" prop="status" />
      <el-table-column label="配送类型" align="center" prop="dvyType" />
      <el-table-column label="配送方式ID" align="center" prop="dvyId" />
      <el-table-column label="物流单号" align="center" prop="dvyFlowId" />
      <el-table-column label="订单运费" align="center" prop="freightAmount" />
      <el-table-column label="用户订单地址Id" align="center" prop="addrOrderId" />
      <el-table-column label="订单商品总数" align="center" prop="productNums" />
      <el-table-column label="付款时间" align="center" prop="payTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.payTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发货时间" align="center" prop="dvyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dvyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="完成时间" align="center" prop="finallyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.finallyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="取消时间" align="center" prop="cancelTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.cancelTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否已经支付，1：已经支付过，0：，没有支付过" align="center" prop="isPayed" />
      <el-table-column label="用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除" align="center" prop="deleteStatus" />
      <el-table-column label="0:默认,1:在处理,2:处理完成" align="center" prop="refundSts" />
      <el-table-column label="优惠总额" align="center" prop="reduceAmount" />
      <el-table-column label="订单类型" align="center" prop="orderType" />
      <el-table-column label="订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易" align="center" prop="closeType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['Greenfarm:tz_order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['Greenfarm:tz_order:remove']"
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

    <!-- 添加或修改订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="店铺id" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入店铺id" />
        </el-form-item>
        <el-form-item label="产品名称,多个产品将会以逗号隔开" prop="prodName">
          <el-input v-model="form.prodName" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="订购用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入订购用户ID" />
        </el-form-item>
        <el-form-item label="订购流水号" prop="orderNumber">
          <el-input v-model="form.orderNumber" placeholder="请输入订购流水号" />
        </el-form-item>
        <el-form-item label="总值" prop="total">
          <el-input v-model="form.total" placeholder="请输入总值" />
        </el-form-item>
        <el-form-item label="实际总值" prop="actualTotal">
          <el-input v-model="form.actualTotal" placeholder="请输入实际总值" />
        </el-form-item>
        <el-form-item label="订单备注" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="配送方式ID" prop="dvyId">
          <el-input v-model="form.dvyId" placeholder="请输入配送方式ID" />
        </el-form-item>
        <el-form-item label="物流单号" prop="dvyFlowId">
          <el-input v-model="form.dvyFlowId" placeholder="请输入物流单号" />
        </el-form-item>
        <el-form-item label="订单运费" prop="freightAmount">
          <el-input v-model="form.freightAmount" placeholder="请输入订单运费" />
        </el-form-item>
        <el-form-item label="用户订单地址Id" prop="addrOrderId">
          <el-input v-model="form.addrOrderId" placeholder="请输入用户订单地址Id" />
        </el-form-item>
        <el-form-item label="订单商品总数" prop="productNums">
          <el-input v-model="form.productNums" placeholder="请输入订单商品总数" />
        </el-form-item>
        <el-form-item label="付款时间" prop="payTime">
          <el-date-picker clearable
            v-model="form.payTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择付款时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发货时间" prop="dvyTime">
          <el-date-picker clearable
            v-model="form.dvyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="完成时间" prop="finallyTime">
          <el-date-picker clearable
            v-model="form.finallyTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择完成时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="取消时间" prop="cancelTime">
          <el-date-picker clearable
            v-model="form.cancelTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择取消时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否已经支付，1：已经支付过，0：，没有支付过" prop="isPayed">
          <el-input v-model="form.isPayed" placeholder="请输入是否已经支付，1：已经支付过，0：，没有支付过" />
        </el-form-item>
        <el-form-item label="0:默认,1:在处理,2:处理完成" prop="refundSts">
          <el-input v-model="form.refundSts" placeholder="请输入0:默认,1:在处理,2:处理完成" />
        </el-form-item>
        <el-form-item label="优惠总额" prop="reduceAmount">
          <el-input v-model="form.reduceAmount" placeholder="请输入优惠总额" />
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
import { listTz_order, getTz_order, delTz_order, addTz_order, updateTz_order } from "@/api/Greenfarm/tz_order";

export default {
  name: "Tz_order",
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
      // 订单表格数据
      tz_orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        prodName: null,
        userId: null,
        orderNumber: null,
        total: null,
        actualTotal: null,
        payType: null,
        remarks: null,
        status: null,
        dvyType: null,
        dvyId: null,
        dvyFlowId: null,
        freightAmount: null,
        addrOrderId: null,
        productNums: null,
        payTime: null,
        dvyTime: null,
        finallyTime: null,
        cancelTime: null,
        isPayed: null,
        deleteStatus: null,
        refundSts: null,
        reduceAmount: null,
        orderType: null,
        closeType: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        prodName: [
          { required: true, message: "产品名称,多个产品将会以逗号隔开不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "订购用户ID不能为空", trigger: "blur" }
        ],
        orderNumber: [
          { required: true, message: "订购流水号不能为空", trigger: "blur" }
        ],
        total: [
          { required: true, message: "总值不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "订购时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单列表 */
    getList() {
      this.loading = true;
      listTz_order(this.queryParams).then(response => {
        this.tz_orderList = response.rows;
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
        orderId: null,
        shopId: null,
        prodName: null,
        userId: null,
        orderNumber: null,
        total: null,
        actualTotal: null,
        payType: null,
        remarks: null,
        status: 0,
        dvyType: null,
        dvyId: null,
        dvyFlowId: null,
        freightAmount: null,
        addrOrderId: null,
        productNums: null,
        createTime: null,
        updateTime: null,
        payTime: null,
        dvyTime: null,
        finallyTime: null,
        cancelTime: null,
        isPayed: null,
        deleteStatus: 0,
        refundSts: null,
        reduceAmount: null,
        orderType: null,
        closeType: null
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
      this.ids = selection.map(item => item.orderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orderId = row.orderId || this.ids
      getTz_order(orderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orderId != null) {
            updateTz_order(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTz_order(this.form).then(response => {
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
      const orderIds = row.orderId || this.ids;
      this.$modal.confirm('是否确认删除订单编号为"' + orderIds + '"的数据项？').then(function() {
        return delTz_order(orderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('Greenfarm/tz_order/export', {
        ...this.queryParams
      }, `tz_order_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
