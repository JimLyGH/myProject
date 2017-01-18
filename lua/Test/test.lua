for i=1,10,2 do
    print(i)
end


local tab = {x=1, y=2, "hello", "world"};
for  k, v in pairs(tab) do
	print(k, v);
end

print("------------------------------");
print(#tab);
for i = 1, #tab do
    print(tab[i]);
end

print("------------------------------");

print(table.maxn(tab));
for i = 1, table.maxn(tab) do
    print(tab[i]);
end
