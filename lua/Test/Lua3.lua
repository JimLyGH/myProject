--[[
require "luasql.mysql"
--mysql = require "luasql.mysql" --д��2

--������������
env = luasql.mysql()
--env = mysql.mysql()  --д��2

--�������ݿ�
conn = env:connect("lua", "root", "654321", "localhost", 3306)
--conn = env:connect(���ݿ�����, �˺�, ����, IP��ַ, �˿ں�)

--�������ݿ�ı����ʽ
conn:execute"SET NAMES UTF8"

--ִ�����ݿ����
cur = conn:execute("select * from userInfo")

--�˴���aָ�����Ը��ӵķ�ʽ��ֻд�ļ�
row = cur:fetch({}, "a") 

--�ļ�����Ĵ���
file = io.open("userInfo.txt","w+");

while row do
    var = string.format("%d %s %d %s\n", row.id, row.name, row.sex, row.address)

    print(var)

    file:write(var)

    row = cur:fetch(row, "a")
end


file:close()  --�ر��ļ�����
conn:close()  --�ر����ݿ�����
env:close()   --�ر����ݿ⻷��



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



--д��һ
myTable = {10, 20, 30}

setmetatable(myTable, {
    __tostring = function(myTable)	--ע��__tostring������_��ͷ
	local sum = 0
	for _,v in pairs(myTable) do
	    sum = sum + v
	end
	return ("��Ԫ��֮��=" .. sum)
    end
})

print(myTable)


--д����
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
    

    return ("��Ԫ��֮��=" .. sum)
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

-- ����Ԫ����__call
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
for k, v in pairs(subjects) do  --��pairs�滻Ϊipairs�Ա�������
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
myTable.key2 = "world"	--��key2��ֵ��ִ��__newindex����

print(myTable.key1, myTable.key2)



myTable = {10, 20, 30}
newTable = {20, 30, 40}

setmetatable(myTable, {
    __add = function(myTable, newTable)
	print("add")	--��������¼�,�ɱ������������е�Ԫ�ؽ����ۼ���Ͳ�����
	return "already add"
    end
})

print(myTable + newTable)

myTable = {10, 20, 30}
newTable = {20, 30, 40}

setmetatable(myTable, {
    __sub = function(myTable, newTable)
	print("subtract")	--��������¼�
	return "already subtract"
    end
})

print(myTable - newTable)


myTable = {10, 20, 30}

setmetatable(myTable, {
    __unm = function(myTable)
	print("nagative")	--��������¼�
	return "already nagative"
    end
})

print(-myTable)


myTable = {10, 20, 30}
num = 100

setmetatable(myTable, {
    __call = function(myTable, param)	--�˴���param���滻�������͵ı���
	print("call " .. param)	--��������¼�
	return "already call"
    end
})

print(myTable(num))	--myTable����num����



myTable = {10, 20, 30}
num = 100

setmetatable(myTable, {
    __pow = function(myTable, param)	--�˴���param���滻�������͵ı���
	print("call " .. param)	--��������¼�
	return "already call"
    end
})

print(myTable ^ num)	--myTable����num����

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











