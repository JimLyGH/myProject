require("luacom");
require("lc");

local name = 'E://' ..  lc.a2u("导出EXCEL案例") .. '.xls';

--创建excel对象
local excel = luacom.CreateObject("Excel.Application"); --创建新的实例

excel.Visible = false;

local book =excel.Workbooks:Add();

--读第一个工作表
local sheet = book.Sheets(1); 

sheet.Cells(1, 1).Value2 = "hello";
sheet.Cells(1, 2).Value2 = lc.a2u("你好");
for i=3, 10, 1 do
  sheet.Cells(1, i).Value2 = "hello" .. i;	
end

sheet.Cells(2, 1).Value2 = "hello";
sheet.Cells(2, 2).Value2 = "java";
for i=3, 10, 1 do
  sheet.Cells(2, i).Value2 = "work" .. i;	
end

for i=1, 10, 1 do
  sheet.Cells(7, i).Value2 = i;	
  sheet.Cells(8, i).Value2 = 100 + i;
end

--公式
sheet.Cells(9,1).Formula = '=A7+A8' 
--公式 R表示行C表示列 R8C2表示第8行第2列
sheet.Cells(9,2).FormulaR1C1 = '=R8C2+R7C2' 
--设置文本颜色
sheet.Cells(1,1).Font.Color = 0x0000ff;

local style = sheet:Range("A1:B1");
--对A1至B1列进行加粗
style.Font.Bold=true;
--设置字体大小
style.Font.size = 30;

--合并单元格
sheet:Range('D3:D6'):Merge();
--整行操作
sheet.Cells(4,5).EntireRow.Interior.Color = 0x334455   
--整列操作
sheet.Cells(4,5).EntireColumn.Interior.Color = 0x998877 

local cell = sheet.Cells(7,1)
cell.Font.Strikethrough = true  --删除线
cell.font.OutlineFont = true    --下划线
--设置文本字体
cell.Font.Name = 'Arial'
--cell.Font.Shadow = true
--cell.Font.SuperScript = true
--cell.Font.SubScript = true

--区域上色，给A8到C8上色
local range = sheet:Range('A8:C8')
range.Interior.Color = 0x778899 
--边框样式 --每个小的内边框
range.Borders.LineStyle = 1 

--外边框
sheet:Range('C2:G7').BorderAround(1)
--边框宽度
range.Borders.Weight = 4      
--区域花纹
range.Interior.Pattern = 8

--统计单元格数
print(range.Cells.Count)    
print(range.Rows.Count)
print(range.Columns.Count)
--格式化数字
range.NumberFormat = '$#,##0.00'
--剪切
--sheet:Range('A9'):Cut()   
--复制
sheet:Range('A9'):Copy()    
--粘贴
sheet:Paste(sheet:Range('A10')) 
--book.Worksheets('sheet3'):Delete()

--设置第一行的行高
sheet.Rows(1).RowHeight = 50;

--设置列宽
for i = 1, 2, 1 do
    sheet.Columns(i).ColumnWidth = 30;
end

-- 保存
book:SaveAs(name);

book:Close();

--[[ 关闭excel -------------]]
excel:Quit();

--释放资源
excel = nil;

collectgarbage();