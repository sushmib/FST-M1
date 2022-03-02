	
list1 = [10, 11, 30, 40, 17]
list2 = [10, 20, 15]
list3=[]
for i in list1:
    if (i % 2) !=0:
        list3.append(i)
for i in list2:
    if (i % 2) ==0:
        list3.append(i)
print("final list: " ,list3)



