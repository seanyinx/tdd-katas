# 简易报警系统

## 条件

```
* ABOVE 高于阈值时报警
* BELOW 低于阈值时报警
* EQUAL 等于阈值时报警
```

## 修饰

```
* NOT   不满足条件时报警
* BREAK 只在突破阈值时报警
```

## 组合

```
* AND   所有条件满足时报警
* OR    任意条件满足时报警
```

## 输入

```
AlertSystemMain [组合]([修饰-]<条件1> <阈值1> <严重度1>[,[修饰-]条件2 阈值2 严重度2,[修饰-]条件3 阈值3 严重度3...]) 
<data>
```

## 输出

```
* OK
* WARNING
* CRITICAL
```

## 例子

```
AlertSystemMain AND(ABOVE 3,BELOW 5) CRITICAL
1,2,3,4,5,6,7
OK,OK,OK,CRITICAL,OK,OK,OK

AlertSystemMain (NOT-BELOW 5) CRITICAL
1,2,3,4,5,6,7
OK,OK,OK,OK,CRITICAL,CRITICAL,CRITICAL

AlertSystemMain OR(BREAK-ABOVE 4,EQUAL 2) WARNING
1,2,3,4,5,6,7,6,5,4,5,6,7
OK,WARNING,OK,OK,WARNING,OK,OK,OK,OK,OK,WARNING,OK,OK
```

