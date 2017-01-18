Car = {};

function Car:new(o)
    o = o or {};
    setmetatable(o, self);
    self.__index = self;

    return o;

end

function Car:Driver()
     print("car can driver");
end

function Car:Oil()
    print("I need Oil");
end

BMW = Car:new(nil);

function BMW:new()
    o = o or {};
    setmetatable(o, self);
    self.__index = self;

    return o;
end

--此处重写了父类Car类的Driver方法
function BMW.Driver()
     print("BMW car can driver");
end

function BMW.Price()
     print("BMW cost 10000");
end


c = Car:new();
c.Driver();
c.Oil();

bmw = BMW:new();
bmw.Driver();

bmw:Oil();
bmw:Price();	


