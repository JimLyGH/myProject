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

stu = Student:new("zhangsan", 10);
stu:info();
--stu.info();--报错
stu.info(stu);

stu1 = Student.new("zhangsan", 10);
stu1:info();
--stu1.info();--报错
stu1.info(stu1);

