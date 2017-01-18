Student = {};
Student.__index = Student;

function Student.new(name, age)
    local temp = {};
    setmetatable(temp, Student);
    temp.name = name;
    temp.age = age;
    return temp;
end


function Student:info()
    print(self.name, self.age);
end

function Student:message()
    print(self.name, self.age);
end

function Student.school()
    print("go to school!!!");
end

--声明类时用点号:Student.new(name, age)
stu = Student:new("zhangsan", 10);
stu:info();	--输出信息错误
stu.school();
--stu.message(); --报错
stu.message(stu);--输出信息错误

mes = Student.new("zhangsan", 10);
--mes.info();	--报错
mes.info(mes);
mes.school();



--声明类时用冒号:Student.new(name, age)
--stu = Student:new("zhangsan", 10);
--stu:info();
--stu.info(stu);
--stu.school();

--mes = Student.new(nil, "mes", 20);
--mes:message();
--mes.school();



