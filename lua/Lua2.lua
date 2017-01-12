--[[
courses = {
    {name="java", ip="192.168.110.187"},
    {name="lua", ip="10.2.255.88"},
    {name="jQuery", ip="192.168.110.54"},
    {name="CSS", ip="192.168.110.134"},
    {name="ORACLE", ip="10.2.255.34"},
}

--����name��network��������
table.sort(courses, function(a, b) 
    return (a.name > b.name)
end)

--���network��ֵ
print "�����coursesΪ��"
for o in pairs(courses) do
    local temp = ''	--tempΪ�ֲ�����
    for k, v in pairs(courses[o]) do
	temp = temp .. ',' .. k .. '_' .. v
    end
--  print(string.sub(temp, 2, string.len(temp)))
    print(string.sub(temp, 2, #temp))	--�±��1��ʼ�����0
end



languges = {
    first = "java",
    second = "lua",
    third = "struts",
    fourth = "hibernate",
    fifth = "spring",
    "all"
}

print("����languges��")
for k, v in pairs(languges) do
    print(k .. ':' .. v)
end

print('����languges��')
print("first:" .. languges["first"])
print(languges[1])
print(languges[2])
print("third:" .. languges["third"])

str1 = "hello"
str2 = "world"
print(str1 .. ' ' .. str2)



for i = 1, 10 do
    if i == 5 then
	print('is:' .. i)
    else
	print(i)
    end
end



local n = 0
while true do
    n = n + 1
    if n > 10 then
	break
    else
	io.write(n .. ' ')
    end
end



function fac (n)
    if n <= 0 then
	return 1
    else
	return n * fac(n-1)
    end
end

print(fac(5))



str = "www.baidu.com"
print(#str)



myTable = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thurday", "Friday", "Saturday"}

for index in pairs(myTable) do
    io.write(myTable[index] .. ' ')
end

print("��һ��Ԫ�أ�" .. myTable[1])


x, y = 10, 20
x , y = y, x
print("x=" .. x .. ' y=' .. y)


local n = 0
repeat
    n = n + 1
    io.write(n .. ' ')
until n >= 10

	

function maxMin(arr) 
    maxNum, minNum = arr[1], arr[1]
    for index in pairs(arr) do
	if arr[index] > maxNum then
	    maxNum = arr[index]
	end

	if arr[index] < minNum then
	    minNum = arr[index]
	end
    end
    return maxNum, minNum
end

myTable = {12, 34, 3, 1, 54, 33, 87, 34}
maxNum, minNum = maxMin(myTable)

print("maxNum=" .. maxNum .. " minNum=" .. minNum)



function ave(...)
    args = {...}
    sum = 0;
    
    for i, v in ipairs(args) do
	sum = sum + v
    end
    return sum / #args
end

print(ave(12, 34, 3, 1, 54, 33, 87, 34))




subArr = {"java", "lua", "c", "c++", "jQuery"}
userInfo = {name="zhangsan", age = 12, sex = "man", addr = "shenzhen"}

--ipairs���滻Ϊpairs
for k,v in ipairs(subArr) do	
    print('k=' .. k .. ' v=' .. v .. ' ' .. subArr[k])
end

print()

--pairs�����滻Ϊipairs
for k,v in pairs(userInfo) do
    print('k=' .. k .. ' v=' .. v .. ' ' .. userInfo[k])
end



local subjects = {   
    "java",   
    "lua",   
    [3] = "c",
    [6] = "c++",
    [5] = "jQuery",
    "css",
    [7] = "jsp"
}   
for k, v in ipairs(subjects) do  
    print(k, v)   
end  




maxNum = function(x, y)
    if x > y then 
	return x
    else
	return y
    end
end

print('maxNum=' .. maxNum(12, 6))



print(10 ~= 10)
print(10 ~= 3)



str1 = "java"
str2 = 'lua'
str3 = "\"hello\""


print(str1)
print(str2)
print(str3)


--���:hemmo world java lua	2
print(string.gsub("hello world java lua", "l", "m", 2))

--���:13	16
print(string.find("hello world java lua", "java", 1))

--���:aul
print(string.reverse("lua"))

--���:LUA
print(string.upper("Lua"))

--���:lua
print(string.lower("Lua"))

--���:3
print(string.len("lua"))

--���:lualualua
print(string.rep("lua", 3))

--���:���ڸ�ʽ��:2016/04/07
year = 2016; month = 4; day = 7
print(string.format("���ڸ�ʽ��:%04d/%02d/%02d", year, month, day))



function square(iteratorMaxCount, currentNumber)
    if (currentNumber < iteratorMaxCount) then
	
	currentNumber = currentNumber + 1
	return currentNumber, currentNumber * currentNumber
    end
end

for index, sqr in square,5,0 do
    print(index, sqr)
end




num = 3;

if num > 10 then
    print("> 10")
elseif num == 10 then
    print("== 10")
else
    print("< 10")
end



local num = 30
str = "hello lua"
print(_G.num)	--����ȫ�ֱ���num����Ϊnum������Ϊ�ֲ��������������Ϊnil
print(_G.str)	--����ȫ�ֱ���str



--������ʽ
--myTable = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thurday", "Friday", "Saturday"}
--table��ʽ��������������ʽ�ǵȼ۵�
myTable = {[1] = "Sunday", [2] = "Monday", [3] = "Tuesday", [4] = "Wednesday", [5] = "Thurday", [6] = "Friday", [7] = "Saturday"}

for index = 1, #myTable do
	io.write(myTable[index] .. ' ')
end
]]







