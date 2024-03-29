# 交易成功提醒
## 目的
* 模拟用户在股票订单成交后，触发交易成功弹框撒花效果
* 练习只覆盖从收到持仓更新到发送交易成功提醒即可
* 提醒消息同时用于前端持仓同步，前端在收到推送时，根据消息内容更新资产页持仓列表

## 需求
* 买多和卖空的订单在成交时，触发提醒
* 平仓时，不触发提醒
* 一个订单同时平仓且反手做多或做空，在其成交时，触发提醒
* 提醒内容
    * userId
    * 股票代码
    * 交易方向：买多或卖空
    * 买卖数量（不含平仓部分）
    * 成交均价
    * 成交金额（不含平仓部分）
    * 交易币种
    * 消息类型
      * 开多
      * 开空
      * 平多
      * 平空
* 数据库和消息队列使用接口即可，无需实现查询和发送逻辑

## 扩展设计
* 如何触发在线提醒？
* 离线期间成交的订单，如何在用户上线时触发提醒？
