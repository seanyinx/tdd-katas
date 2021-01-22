# 自动贩卖机
在本练习中，您将建立自动售货机的大脑。它将接受零钱，进行找零，维护库存并分配产品。

## 功能
### 接收零钱
自动售货机将接受有效的硬币（nickels, dimes, and quarters），并拒绝无效的硬币（pennies）。插入有效硬币后，该硬币的数量将添加到当前数量，并且显示将更新。
没有插入硬币时，机器显示"INSERT COIN"。被拒绝的硬币被放置在硬币退回中。

注意：可以使用字符串，常量，枚举，符号或类似性质的东西来模拟插入的硬币。示例：
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回
1. `> NICKLE` 投入硬币NICKLE
1. `> 0.05 / -` 显示当前硬币金额"0.05"美元，无硬币退回
1. `> DIME` 投入硬币DIME
1. `> 0.15 / -` 显示当前硬币金额"0.15"美元，无硬币退回
1. `> PENNY` 投入硬币PENNY
1. `> 0.15 / PENNY` 显示当前硬币金额"0.15"美元，硬币退回PENNY

### 选择商品
一共有三种商品：cola的价格为1.00美元，chips的价格为0.50美元，candy的价格为0.65美元。
当按下相应的按钮并且已插入足够的钱时，便分配商品，并且机器显示“THANK YOU”，随后显示"INSERT COIN"，当前金额将设置为$ 0.00。
如果没有足够的钱，则机器会显示"PRICE 物品的价格"，随后显示"INSERT COIN"。
示例：
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.25 / -` 显示当前硬币金额"0.25"美元，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.50 / -` 显示当前硬币金额"0.50"美元，无硬币退回
1. `> CHIPS` 选择商品CHIPS
1. `> THANK YOU / -` 显示"THANK YOU"，无硬币退回
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回

### 找零
如果选择的商品的价格低于投入机器中的金额，则剩余的金额将被放入硬币退回中。
示例：
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.25 / -` 显示当前硬币金额"0.25"美元，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.50 / -` 显示当前硬币金额"0.50"美元，无硬币退回
1. `> CANDY` 选择商品CANDY
1. `> PRICE 0.65 / -` 显示商品价格"0.65"美元，无硬币退回
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.75 / -` 显示当前硬币金额"0.75"美元，无硬币退回
1. `> CANDY` 选择商品CANDY
1. `> THANK YOU / DIME` 显示"THANK YOU"，硬币退回DIME
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回

### 退币
按下返回硬币按钮时，将退还客户放入机器中的钱，并且显示屏上显示"INSERT COIN"。
示例：
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.25 / -` 显示当前硬币金额"0.25"美元，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.50 / -` 显示当前硬币金额"0.50"美元，无硬币退回
1. `> RETURN` 按下退回硬币按钮
1. `> INSERT COIN / QUARTER QUARTER` 显示"INSERT COIN"，硬币退回QUARTER两枚

### SOLD OUT
当客户选择的物品缺货时，机器显示"SOLD OUT"，随后将显示机器中剩余的钱数；如果机器中没有钱，则显示"INSERT COIN"。
1. `> INSERT COIN / -` 显示"INSERT COIN"，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.25 / -` 显示当前硬币金额"0.25"美元，无硬币退回
1. `> QUARTER` 投入硬币QUARTER
1. `> 0.50 / -` 显示当前硬币金额"0.50"美元，无硬币退回
1. `> CHIPS` 选择商品CHIPS
1. `> SOLD OUT / -` 显示"SOLD OUT"，无硬币退回
1. `> 0.50 / -` 显示当前硬币金额"0.50"美元，无硬币退回

### Exact Change Only
如果机器无法找零，它将仅显示“EXACT CHANGE ONLY”而不是“INSERT COIN”。
