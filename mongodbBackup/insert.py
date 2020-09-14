import pymongo
import random
from bson import ObjectId
cliente = pymongo.MongoClient("mongodb://localhost:27017/")
db = cliente["tbd"]
emergencia = db["emergencia"]
institucion = db["institucion"]
i=0
if(institucion.find().count()<100):

	while i<100:
		nombre="institucion_"+str(i)
		descrip="descrip_"+str(i)
		insert= {"nombre":nombre,"descrip":descrip,"emergencias":[]}
		institucion.insert_one(insert)
		i+=1
		print(str(i)+"instituciones han sido agregadas")
else:
	print("no es necesario agregar mas instituciones")

i=0
instituciones_count=institucion.find().count()
instituciones=institucion.find()

while i<1000:
	nombre="emergencia_"+str(i)
	descrip="descrip_"+str(i)
	a1=random.randint(1950,2019)
	a2=random.randint(a1+1,2020)
	finicio= str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(a1)
	ffin=str(random.randint(1,31))+"-"+str(random.randint(1,12))+"-"+str(a2)
	insert={"nombre":nombre,"descrip":descrip,"finicio":finicio,"ffin":ffin}
	emergencia.insert_one(insert)
	j=0
	rand=random.randint(0,instituciones_count-1)
	while j<rand:
		j+=1
	emergencias=instituciones[j]['emergencias']
	emergencias.append(insert)

	obj=instituciones[j]['_id']
	doc=institucion.find_one_and_update(
	{"_id":obj},
	{"$set":
		{'emergencias': emergencias}
	}
	)
	i+=1
	print(str(i)+" Emergencias han sido agregadas")
print("Finalizado")
