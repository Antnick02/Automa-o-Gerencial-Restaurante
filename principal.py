'''/*******************************************************************************
Aluno: Antonio Nicassio Santos Lima
Componente Curricular: EXA854 - Mi - Algoritmos
Concluído em: 06/06/2021
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/'''

#Comandos que importam algumas bibliotecas e funções que serão utilizadas no programa
from Cliente import *
from Manutencao import *
from datetime import date, datetime

#Demonstra as opções do menu principal e retorna a opção escolhia
def menu():
    print(''' 
Bem vindo ao gerenciador de manutenções!!! 

[1]Aba clientes 
[2]Aba manutenções 
[3]Balanço mensal 
[4]Sair
''')
    opcao = input('Escolha uma opção: ')
    return opcao

#Recebe o mês e o ano do balanço e verifica se são válidos, tentando transformar em uma datá válida
#e retornando True caso consiga e False se não conseguir
def verificaDataBalanco(metadeData):
    diaData = '03/'
    data = diaData + metadeData
    try:
        datetime.strptime(data, '%d/%m/%Y').date()
        return True
    except:
        return False

#Recebe o mês e o ano para realizar o balanço, e busca na lista de manutenções realizadas, manutenções
#com o mesmo mês e ano correspondentes as adicionando em uma lista e retornanda-a
def verificaManuReal(mesAno, listaManuReal):
    lista = []
    for manutencao in listaManuReal:
        data = manutencao.get_data()
        if mesAno == data[3:]:
            lista.append(manutencao)
    return lista

#Recebe a lista de manutenções realizadas verifica se não está vazia, e passa as manutenções
#de forma formata para um arquivo txt, junto com o custo total de todas elas
def imprimirBalanco(listaManuReal):
    if listaManuReal:
        custoTotal = 0
        contador = 1
        with open('ImpressaoBalancoMensal.txt', 'w') as arquivo:
            arquivo.write('{0:^76}\n'.format('Manutenções Realizadas'))
            arquivo.write('{0:<6} | {1:^10} | {2:^7} | {3:^9} | {4:^10} | {5:^5} | {6:^7}'.format('Código', 'Peça', 'Custo', 'Data', 'Cliente', 'Prazo', 'Periodo'))
            arquivo.write('\n')
            for manutencao in listaManuReal:
                custoTotal += manutencao.get_preco()
                if contador < len(listaManuReal):
                    arquivo.write('{0:^6} | {1:^10} | R${2:^5} |{3:^9} | {4:^10} | {5:^5} | {6:^7}\n'.format(
                        manutencao.get_codigo(),
                        manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                        manutencao.get_prazo(), manutencao.get_periodo()))
                elif contador == len(listaManuReal):
                    arquivo.write('{0:^6} | {1:^10} | R${2:^5} |{3:^9} | {4:^10} | {5:^5} | {6:^7}\n'.format(
                        manutencao.get_codigo(),
                        manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                        manutencao.get_prazo(), manutencao.get_periodo()))
                    arquivo.write('Custo Total: R${0:<76}'.format(custoTotal))
                contador += 1

#Recebe a lista de manutenções realizadas verifica se não está vazia, imprime as manutenções
#de forma formata para o usuário junto com o custo total de todas elas, e pergunta para o
#usuário se quer imprimi-las(passar para um arquivo txt), caso queira o faz
def balancoMensal(listaManuReal):
    if listaManuReal:
        custoTotal = 0
        contador = 1
        print()
        print('{0:^76}\n'.format('Manutenções Realizadas'))
        print('{0:<6} | {1:^10} | {2:^7} | {3:^9} | {4:^10} | {5:^5} | {6:^7}'.format('Código', 'Peça', 'Custo', 'Data', 'Cliente', 'Prazo', 'Periodo'))
        print()
        for manutencao in listaManuReal:
            custoTotal += manutencao.get_preco()
            if contador < len(listaManuReal):
                print('{0:^6} | {1:^10} | R${2:^5} |{3:^9} | {4:^10} | {5:^5} | {6:^7}\n'.format(
                    manutencao.get_codigo(),
                    manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                    manutencao.get_prazo(), manutencao.get_periodo()))
            elif contador == len(listaManuReal):
                print('{0:^6} | {1:^10} | R${2:^5} |{3:^9} | {4:^10} | {5:^5} | {6:^7}\n'.format(
                    manutencao.get_codigo(),
                    manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                    manutencao.get_prazo(), manutencao.get_periodo()))
                print('Custo Total: R${0:<76}'.format(custoTotal))
            contador += 1
        print()
        opcao = input('Deseja imprimir este balanço mensal?(s/n):').lower()

        #looping para verificar se opção digitada pelo usuário é válida e caso seja o comando para
        #imprimir as manutenções é realizado
        while opcao != 's' and opcao != 'n':
            print()
            print('Opção inválida, tente novamente')
            print()
            opcao = input('Deseja imprimir este balanço mensal?(s/n):').lower()
        if opcao == 's':
            imprimirBalanco(listaManuReal)
            print()
            print('Balanço Mensal impresso!!!')

#Menu que contém e controla todas as funcionalidades do programa
def mainP():

    #Comando responsável por pegar as listas com os objetos dos arquivos binários
    #e os passa para memória do programa como variavéis
    listaClientes = arquivoClientesLista()
    listaManuAgen = arquivoManuAgenLista()
    listaManuReal = arquivoManuRealLista()

    #Pega o código dos clientes a partir do último cliente da lista,
    #que será alterado ao longo do programa e o subtrai por 1
    #para que a ordenação do código de quando se cria um novo cliente fique correta
    #já que na criação do objeto é adicionado +1 no código para que possa diferenciar
    codigo = obtemCodigoCliente(listaClientes) - 1

    #Segue a mesma lógica dos clientes, entretanto obtém-se das listas de manutenções
    #agendadas e realizadas e não subtraindo 1 ainda
    cod_1 = obtemCodigoManuAgen(listaManuAgen)
    cod_2 = obtemCodigoManuReal(listaManuReal)

    #Compara-se qual dos dois códigos é o maior para ser utilizado durante o programa
    #e depois subtrai-se 1 deles pelo mesmo motivo do código dos clientes
    if cod_1 > cod_2:
        cod = cod_1 - 1
    else:
        cod = cod_2 - 1

    #Mostra-se as opções e retorna a opção escolhida
    opcao = menu()

    #Looping do menu
    while opcao != '4':

        #Caso o usuário escolha alguma dessas opções irá para segmentos diferentes do programa
        if opcao == '1':

            #Adentra nas opções apresentadas pela aba clientes e devolve o código dos clientes que pode
            #ter sido alterado dentro dessa parte do programa
            codigo = menuClientes(listaClientes, codigo, listaManuReal, listaManuAgen)

            #Comando que salva as alterações que podem ter sido feitas na lista dos clientes no arquivo binário
            listaClientesArquivo(listaClientes)
        elif opcao == '2':

            #Adentra nas opções apresentadas pela aba manutenções e devolve o código das manutenções que pode
            #ter sido alterado dentro dessa parte do programa
            cod = menuManu(listaManuAgen, listaManuReal, listaClientes, cod)

            #Comandos que salvam as alterações que podem ter sido feitas na lista das manutenções realizadas e agendadas
            #nos arquivo binários correspondentes
            listaManuAgenArquivo(listaManuAgen)
            listaManuRealArquivo(listaManuReal)
        elif opcao == '3':
            #Parte do programa que recebe o mês e o ano para realização do balanco mensal

            print()
            mesAno = input('Digite o mês e o ano das manutenções, para realizar o balanço(formato: 00/0000): ').strip()

            #Looping para verificar se a data informada respeita o formato informatdo para que seja utilizada ao longo
            #do programa
            while not verificaDataBalanco(mesAno):
                print()
                print('Formato inválido, por favor digite neste formato Ex: 08/2021')
                print()
                mesAno = input('Mês e ano: ')

            #Comando que atribui a uma variável uma lista contendo as prováveis manutenções com o mês e o ano passado
            #pelo usuário
            listaManuBalanco = verificaManuReal(mesAno, listaManuReal)

            #Verifica se a lista recebida não é vazia e devolve uma mensagem para o usuário caso a lista esteja vazia
            if listaManuBalanco:
                #Comando que recebe a lista com as manutenções do periodo passado, mostra ao usuário e os imprime
                #Caso ele queira
                balancoMensal(listaManuReal)
            else:
                print()
                print('Nenhuma Manutenção encotrada para este período, verifique as informações e tente novamente')
        else:
            print()
            print('Opção inválida, tente novamente')
        opcao = menu()

    #Após o usuário escolher a opção de sair, todas alterações feitas são salvas
    #novamente nos arquivos binários correspondentes e uma mensagem dizendo ao usuário
    #que ele saiu é mostrada
    listaClientesArquivo(listaClientes)
    listaManuAgenArquivo(listaManuAgen)
    listaManuRealArquivo(listaManuReal)
    print()
    print('Você saiu ...')

#Comando que inicia o programa
mainP()