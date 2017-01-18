require("luacom");
require("lc");

local Excel = {};

function Excel.open(filename)
	local t = io.open(filename, "r")
	if not t then
		return nil, "File not exist"
	else
		t:close()
	end
	local excel = luacom.CreateObject("Excel.Application")
	if not excel then
		return nil, "CreateObject Excel.Application fail"
	end
	assert(luacom.GetType(excel) == "LuaCOM")
	local isVisible = 0
	local isReadOnly = 0
	excel.Visible = isVisible
	excel.WorkBooks:Open(filename, nil, isReadOnly)
	return excel
end

function Excel.selectSheet(excel, sheet)
	return excel.ActiveWorkbook.Sheets(sheet):Select()
end

function Excel.close(excel)
	local save = 0
	local alerts = 0
	excel.Application.DisplayAlerts = alerts
	excel.Application.ScreenUpdating = alerts
	excel.Application:Quit()
end

function Excel.read(excel, row, column)
	return excel.Activesheet.Cells(row, column).Value2
end

function Excel.write(excel, row, column, temp)
	excel.Activesheet.Cells(row, column).Value2 = temp;
end

--案例
local excel = Excel.open("d:\\test.xlsx");
Excel.selectSheet(excel, 1);
for i = 1,5 do
	local content = "";
	for j = 1,5 do
		t = Excel.read(excel, i, j);
		if (t ~= nil) then
			content = content .. ' ' .. t;
		end
	end
	print(content)
end;
Excel.close(excel)

print("############################################")
for k,v in pairs(lc) do
--    print(k)
end
--print(lc.help())