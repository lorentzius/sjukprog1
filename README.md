#inlupp1
def is_sorted(list):

    if len(list)==0:
        return f'Har inga element'

    if len(list)==1:
        return f'Har enbart ett element'

    lista_i_ordning=True
    for index in range(len(list)-1): #en minus etta sätts efer len då rangen hade förstört då den hade räknat efter sista indexet där det inte finns ett index, hade blivit error
        if list[index] >= list[index+1]:
            lista_i_ordning=False
    return lista_i_ordning

def test():
    lista_1=[]
    lista_2=[0]
    lista_3=[1]
    lista_4=[1,1,1,1]
    lista_5=[1,2,3,4]
    lista_6=[1,3,5,0]
    lista_7=[1,2,1,4]
    lista_8=[1,2,3,7,8]
    lista_9=[1,12,32,40]
    all_list=[lista_1, lista_2, lista_3, lista_4, lista_5, lista_6, lista_7, lista_8, lista_9]
    for list in all_list:
     print ("listan", list, is_sorted(list))

test()
