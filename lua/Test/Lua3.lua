--[[
require "luasql.mysql"
--mysql = require "luasql.mysql" --写法2

--创建环境对象
env = luasql.mysql()
--env = mysql.mysql()  --写法2

--连接数据库
conn = env:connect("lua", "root", "654321", "localhost", 3306)
--conn = env:connect(数据库名称, 账号, 密码, IP地址, 端口号)

--设置数据库的编码格式
conn:execute"SET NAMES UTF8"

--执行数据库操作
cur = conn:execute("select * from userInfo")

--此处的a指的是以附加的方式打开只写文件
row = cur:fetch({}, "a") 

--文件对象的创建
file = io.open("userInfo.txt","w+");

while row do
    var = string.format("%d %s %d %s\n", row.id, row.name, row.sex, row.address)

    print(var)

    file:write(var)

    row = cur:fetch(row, "a")
end


file:close()  --关闭文件对象
conn:close()  --关闭数据库连接
env:close()   --关闭数据库环境



t1 = {1, 2, 3}
t2 = {4,5,6,7,8}

mt = {}
mt.__add = function(a, b)
    local ret = 0
    for _, v in pairs(a) do
        ret = ret + v
    end
    for _, v in pairs(b) do
        ret = ret + v
    end
    return ret
end

setmetatable(t1, mt)
setmetatable(t2, mt)
print(t1 + t2)



--写法一
myTable = {10, 20, 30}

setmetatable(myTable, {
    __tostring = function(myTable)	--注意__tostring是两个_开头
	local sum = 0
	for _,v in pairs(myTable) do
	    sum = sum + v
	end
	return ("表元素之和=" .. sum)
    end
})

print(myTable)


--写法二
myTable = {10, 20, 30}

mt = {}

mt.__tostring = function(myTable)
    local sum = 0
    for _,v in pairs(myTable) do
	sum = sum + v
    end
    
   
 --   for index = 1,#myTable do
--        sum = sum + myTable[index]
--    end
    

    return ("表元素之和=" .. sum)
end

setmetatable(myTable, mt)

print(myTable)


function table_maxn(t)
    local mn = 0
    for k, v in pairs(t) do
        if mn < k then
            mn = k
        end
    end
    return mn
end

-- 定义元方法__call
mytable = setmetatable({10, 20}, {
  __call = function(mytable, newtable)
	sum = 0
	for i = 1, table_maxn(mytable) do
		sum = sum + mytable[i]
	end
	for i = 1, table_maxn(newtable) do
		sum = sum + newtable[i]
	end
	return sum
  end
})
newtable = {10,20,30, 40}
print(mytable(newtable))



Rectangle = {area = 0, length = 0, breadth = 0}

function Rectangle:new (o,length,breadth)
  o = o or {}
  setmetatable(o, self)
  self.__index = self
  self.length = length or 0
  self.breadth = breadth or 0
  self.area = length*breadth;
  return o
end


function Rectangle:printArea ()
  print("The area of Rectangle is ",self.area)
end

r = Rectangle:new(nil,10,20)

print(r.length)



local subjects = {   
    "java",   
    "lua",   
    [7] = "c",
     "c++",
    [5] = "jQuery", --[5] = "jQuery",
    "css",
    [6] = "jsp"
}   
for k, v in pairs(subjects) do  --将pairs替换为ipairs对比输出结果
    print(k, v)   
end  



myTable = {key1 = "lua", key3 = "java"}


myTable = setmetatable({key1 = "lua", key3 = "java"}, {
    __index = function(myTable, key)
        if key == "key2" then
	    
		return "key2 is nil"
	    
	else
	    return myTable[key]
	end
    end
})

print(myTable.key1, myTable.key2, myTable.key3)

mytable = setmetatable({key1 = "value1"}, { __index = { key2 = "metatablevalue" } })
print(mytable.key1,mytable.key2)


myTable = {key1 = "lua", key3 = "java"}

setmetatable(myTable, {
    __newindex = function(myTable, key, value)
	print(key .. " is not exists in myTable " .. value)
    end
})

myTable.key1 = "hello"
myTable.key2 = "world"	--给key2赋值会执行__newindex函数

print(myTable.key1, myTable.key2)



myTable = {10, 20, 30}
newTable = {20, 30, 40}

setmetatable(myTable, {
    __add = function(myTable, newTable)
	print("add")	--处理相关事件,可遍历两个对其中的元素进行累加求和并返回
	return "already add"
    end
})

print(myTable + newTable)

myTable = {10, 20, 30}
newTable = {20, 30, 40}

setmetatable(myTable, {
    __sub = function(myTable, newTable)
	print("subtract")	--处理相关事件
	return "already subtract"
    end
})

print(myTable - newTable)


myTable = {10, 20, 30}

setmetatable(myTable, {
    __unm = function(myTable)
	print("nagative")	--处理相关事件
	return "already nagative"
    end
})

print(-myTable)


myTable = {10, 20, 30}
num = 100

setmetatable(myTable, {
    __call = function(myTable, param)	--此处的param可替换其他类型的变量
	print("call " .. param)	--处理相关事件
	return "already call"
    end
})

print(myTable(num))	--myTable调用num变量



myTable = {10, 20, 30}
num = 100

setmetatable(myTable, {
    __pow = function(myTable, param)	--此处的param可替换其他类型的变量
	print("call " .. param)	--处理相关事件
	return "already call"
    end
})

print(myTable ^ num)	--myTable调用num变量

print "sleep"

os.execute("sleep 3s")

print(os.date("%Y-%m-%d %H:%M:%S"))

--print(os.execute('echo $HOME'))



myTable = {}
table.insert(myTable, "1")
print(myTable[1])


local n = 0;
  
while(n < 10) do 
	n = n + 1;
	print(n)
end


w = {x=0, 2, label="console"}
 for i, v in ipairs(w) do
 print(i,v)
end


function add(a, b)
    local m = 10;
    return a + b, 'info';
end

resF, res, m, n = pcall(add, 1, 2)

print(resF, res, m, n)


print (a == nil and a == '')


local str = '2,3,4,84000001';

str = ',' .. str .. ','

local s = '1';
s = ',' .. s .. ',';

if string.find(str, s, 1) == nil then
    print(123);
end
]]

for i = 1, 10, 2 do
    print(i)
end











