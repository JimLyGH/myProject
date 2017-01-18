local file='E://123.txt';
local content = "";
for line in io.lines(file) do
   -- print(line)
 -- io.write(string.format("%s", "Kayak") ,line,"\n")
    local f = assert(io.open(file, 'w'))
    content=line .. 'Kayak';
    f:write(content)
    f:close()
end




