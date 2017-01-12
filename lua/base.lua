Base = {};

function Base:new(o)
    o = o or {};
    setmetatable(o, self);
    self.__index = self;
    return o;
end


function Base:Common()
    print("Base common function");
end


function hello()
    print("hello");
end

