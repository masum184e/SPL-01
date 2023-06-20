f = open("data.txt", "r")
# e = open("demotile2.txt", "a")
# t.write("Now the tile has more content!")
# t.close()
# print(f.read())
e=open("d.txt","a")
x=0
id=""
for i in f:
  if len(str(x))==1:
    id="000"+str(x+1)
  elif len(str(x))==2:
    id="00"+str(x+1)
  elif len(str(x))==3:
    id="0"+str(x+1)
  elif len(str(x))==4:
    id=str(x+1)
  # print("{")
  # print("\"id\":\"w"+id+"\",")
  # print("\"word\":\""+str(i)+"\"")
  # print("},\b")


  # print("[")
  # print("  {")
  # print("    \"id\":\"w"+id+"\",")
  # print("    \"word\":\""+str(i)+"\"")
  # print("  }")
  # print("],")

  strr="[\n  {\n    \"id\":\"w"+id+"\",\n    \"word\":\""+i+"helloworld\"  }\n],"

  # strr="{\n\"id\":\"w"+id+"\",\n\"word\":\""+str(i)+"\"},"
  e.write(strr)
  x=x+1