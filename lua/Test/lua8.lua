require("base");

hello();

b = Base:new(nil);

b.Common();


Lua8 = Base:new(nil);

function Lua8:new(o)
    o = o or {};
    setmetatable(o, self);
    self.__index = self;
    return o;
end

function Lua8:Common()
    print("重写Base的Common方法");
end

l = Lua8:new(nil);
l:Common();
