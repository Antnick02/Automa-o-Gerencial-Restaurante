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
from pickle import load, dump

#Definição e criação da classe Cliente para criação dos objetos
class Cliente:
    def __init__(self, nome, endereco, telefone, codigo): 
        self.nome = nome 
        self.endereco = endereco 
        self.telefone = int(telefone) 
        self.codigo = int(codigo) + 1

    #Funções que retornam os atributos do objeto
    def get_nome(self): 
        return self.nome 
    
    def get_endereco(self): 
        return self.endereco 
    
    def get_telefone(self): 
        return self.telefone 

    def get_codigo(self): 
        return self.codigo 

    #Funções que modificam alguns atributos do objeto
    def set_nome(self, novoNome): 
        self.nome = novoNome 

    def set_endereco(self, novoEndereco): 
        self.endereco = novoEndereco
    
    def set_telefone(self, novoTelefone): 
        self.telefone = novoTelefone 

#Função que pega os dados do arquivo binário e passa para uma variável e a retorna
def arquivoClientesLista():
    with open('clientes.dat', 'rb') as arquivo:
        lista = load(arquivo)
    return lista

#Função que recebe uma lista e retorna um valor para o código a partir da lista recebida
def obtemCodigoCliente(lista):
    if lista == []:
        return 0
    else:
        codigo = lista[-1].get_codigo()
        return codigo + 1

#Função que pega os dados da lista que recebe e passa para o arquivo binário
def listaClientesArquivo(lista):
    if lista:
        with open('clientes.dat', 'wb') as arquivo:
            dump(lista, arquivo)
    else:
        with open('clientes.dat', 'wb') as arquivo:
            dump([], arquivo)

#Função que mostra as opções do menu dos clientes e retorna a opção escolhida
def menu(): 
    print(''' 
Menu Clientes!!! 

[1]Cadastrar 
[2]Editar
[3]Excluir 
[4]Listar 
[5]Sair
''')
    opcao = input('Escolha uma opção: ')
    return opcao 

#Função que recebe uma lista e mostra os nomes do clientes e seus respectivos códigos
def listarClientesCodigo(lista):
    print()
    print('{0:^15}|{1:^15}'.format('Nome', 'Código'))
    for cliente in lista:
        print('{0:^15} {1:8}'.format(cliente.get_nome(),cliente.get_codigo()))

#Função que recebe código do cliente e uma lista com clientes, busca o cliente a partir
#do código e mostra todas as informações do cliente
def listarDadosCliente(codigo, lista):

    #Parte que busca o o cliente do código passado
    for cliente in lista:
        if cliente.get_codigo() == codigo:
            escolhido = cliente


    print()
    print('Dados cliente')
    print()
    print('Nome  - {0:^15}'.format(escolhido.get_nome()))
    print()
    print('End.  - {0:^15}'.format(escolhido.get_endereco()))
    print()
    print('Tel.  - {0:^15}'.format(escolhido.get_telefone()))
    print()
    print('Cód.  - {0:^15}'.format(escolhido.get_codigo()))

#Função que recebe a lista de clientes cria uma copia dela para ser alterada,  a ordena
#com base na ideia de ordenação por seleção e retorna a lista ordenada por ordem alfabética
def ordenaClientes(lista):
    copiaLista = lista.copy()
    if len(copiaLista) == 1:
        return lista
    else:
        for i in range(0, len(copiaLista) - 1):
            min = i
            for j in range(i + 1, len(copiaLista)):
                if copiaLista[j].get_nome() < lista[min].get_nome():
                    min = j
            copiaLista[i], copiaLista[min] = copiaLista[min], copiaLista[i]
    return copiaLista

#Função que recebe a lista de clientes e o código do cliente, e adiciona na lista de clientes um novo
#objeto da classe cliente e retorna o inteiro 1 para ser adicionado ao código indicando que um novo cliente
#foi cadastrado
def cadastrar(lista, codigo):
    #Parte que pede as informações do cliente
    print()
    print('Digite as informações do cliente')
    print()
    nome = input('Digite o nome: ').title()
    print()
    endereco = input('Digite o endereço: ')
    print()
    telefone = input('Digite o telefone: ')

    #looping que verifica se o telefone é válido e se já não está sendo utilizado
    #caso esteja válido, a variável verificador se torna 3 e sai do looping e para
    #de verificar
    verificador = 2
    while verificador != 3:
        verificador = 2
        while not verificaCodigo(telefone):
            print()
            print('Telefone inválido, por favor digite novamente')
            print()
            telefone = input('Digite o telefone:')
            verificador -= 1
        telefone = int(telefone)
        if verificaExistencia(lista, telefone):
            print()
            print('Telefone já cadastrado digite um número alternativo por favor')
            print()
            telefone = input('Digite o telefone: ')
            verificador -= 1
        verificador += 1
    #Adiciona a lista clientes o objeto da classe cliente a partir dos dados cadastrados
    lista.append(Cliente(nome, endereco, telefone, codigo))
    print()
    print('cadastrado!!')
    return 1

#Menu da parte do programa de editar que mostra as opções
#e retorna a opção escolhida
def menuEditar():
    print('''
Informações Cliente

[1]Nome 
[2]Endereço 
[3]Telefone
[4]Sair
''')
    opcao = input('O que deseja alterar?: ')
    return opcao

#Parte do programa editar que recebe a lista de clientes, pede o código, e a partir
#do cliente com código correspondente e mostrado um menu com as opções de atributos que podem ser
#modificados os modificam
def editar(lista):
    print()

    #Se a lista de clientes não estiver vazia, entra na parte do programa em que se pode
    #editar o objeto cliente, se estiver vazia aparece uma mensagem indicando isso
    if lista:
        codi = input("Digite o código do cliente que quer editar: ")

        #looping que verifica se o código é válido, e caso não seja, aparece um aviso, e pede
        #o código novamente
        while not verificaCodigo(codi):
            print()
            print('Código inválido, por favor digite um código válido e tente novamente')
            print()
            codi = input("Digite o código do cliente que quer editar: ")

        #Verifica se o código existe na lista de clientes, indicando que o cliente existe e continua no programa
        #caso não exista nenhum código correspondente na lista de clientes um aviso é mostrado
        if verificaExistencia(lista, int(codi)):

            #Comando que mostra o nome do cliente do código escolhido e pergunta ao usário se o cliente mostrado
            #é aquele que quer editar
            print()
            opi = input('{0} é o cliente que quer editar?(s/n): '.format(verificaCliente(lista, int(codi)))).lower()

            #looping que verifica se opção escolhida é válida, e se for válida e opcao for igual a 'n', uma mensagem
            #é mostrada e retornado 0 saindo assim da função
            while opi != 's' and opi != 'n':
                print()
                print('Opção inválida digite novamente')
                print()
                opi = input(
                    '{0} é o cliente que quer editar?(s/n): '.format(verificaCliente(lista, codi))).lower()
            if opi == 'n':
                print()
                print('Verifique as informações e tente novamente')
                return 0

            #Recebe o número da posição que o cliente está na lista a partir do código que é passado
            posicao = buscaCliente(lista, int(codi))

            #Parte responsável por mostrar as opções do menu escolhido e a opção escolhida
            op = menuEditar()

            #Looping do menu editar, que pela opção ecolhida, é modificado o atributo do cliente
            #da posição da lista passada, a partir do dado inserido pelo usuário que é verificado pelo programa,
            #certo atributo do objeto é trocado pela função set e ocorre um break saindo do
            #looping do menu editar e saindo da função
            while op != '4':
                if op == '1':
                    print()
                    nome = input('Digite o novo nome: ').title()
                    lista[posicao].set_nome(nome)
                    print()
                    print("Nome alterado com sucesso!!")
                    break
                elif op == '2':
                    print()
                    endereco = input('Digite o novo endereço: ')
                    lista[posicao].set_endereco(endereco)
                    print()
                    print('Endereço alterado com sucesso!!')
                    break
                elif op == '3':
                    print()
                    telefone = input('Digite o novo telefone: ')
                    verificador = 2
                    while verificador != 3:
                        verificador = 2
                        while not verificaCodigo(telefone):
                            print()
                            print('Telefone inválido, por favor digite novamente')
                            print()
                            telefone = input('Digite o telefone:')
                            verificador -= 1
                        telefone = int(telefone)
                        if verificaExistencia(lista, telefone):
                            print()
                            print('Telefone já cadastrado digite um número alternativo por favor')
                            print()
                            telefone = input('Digite o telefone: ')
                            verificador -= 1
                        verificador += 1
                    lista[posicao].set_telefone(int(telefone))
                    print()
                    print('Telefone alterado com sucesso!!')
                    break
                else:
                    print()
                    print('Opção inválida, tente novamente')
                op = menuEditar()
        else:
            print()
            print('Não existe um cliente com este código, verifique as informações e tente novamente')
    else:
        print()
        print('Nenhum cliente cadastrado, por favor cadastre ao menos um cliente')

#Função que recebe a lista de clientes,lista de manutenções agendadas e realizadas
#e exclui o cliente da lista de clientes a partir do código passado
def excluir(lista, listaManuReal, listaManuAgen):
    if lista:
        print()
        codi = input("Digite o codigo do cliente que quer excluir: ")
        print()
        #Função que verifica se o código é válido
        while not verificaCodigo(codi):
            print()
            print('Código inválido, por favor digite novamente')
            print()
            codi = input("Digite o codigo do cliente que quer excluir: ")
        if verificaExistencia(lista, int(codi)):

            #Comando que mostra o nome do cliente do código escolhido e pergunta ao usário se o cliente mostrado
            #é aquele que quer excluir
            print()
            opi = input('{0} é o cliente que quer excluir?(s/n): '.format(verificaCliente(lista, int(codi)))).lower()
            while opi != 's' and opi != 'n':
                print()
                print('Opção inválida digite novamente')
                opi = input(
                    '{0} é o cliente que quer excluir?(s/n): '.format(verificaCliente(lista, codi))).lower()

            #Caso opi seja igual a 'n' um aviso é mostrado e um aviso é mostrado e retorna 0 para sair da função
            if opi == 'n':
                print()
                print('Verifique as informações e tente novamente')
                return 0

            #Caso o cliente esteja vinculado a alguma manutenção uma mensagem é mostrada e retorna 0 saindo da função
            if verificaVinculacao(verificaCliente(lista, int(codi)), listaManuReal, listaManuAgen):
                print()
                print('Cliente vinculado a uma manutenção, não pode ser excluido!!')
                return 0

            #Pega o número da posição do cliente a aprtir do código
            posicao = buscaCliente(lista, int(codi))

            #Exclui o cliente da lista clientes a partir da posição passada e e atribui a variável excluido
            #o objeto cliente que foi excluido da lista
            excluido = lista.pop(posicao)

            #Mensagem de confirmação que o cliente foi excluido
            print()
            print("{0} foi excluido(a) com sucesso!!".format(excluido.get_nome()))
        else:
            print()
            print('Código inválido, Verifique as informações e tente novamente')
    else:
        print()
        print('Nenhum cliente cadastrado, por favor cadastre ao menos um cliente')

#Função que recebe a lista clientes, verifica se não está vazia, lista os clientes pelo
#nome e código, e caso o usuário queira ver todas as informações do cliente, ele digita
#o código do cliente e todos atributos são mostrados
def listar(lista):
    if lista:
        print()

        #Função que recebe a lista de clientes e retorna ordenada alfabeticamente
        listaClientesOrdenada = ordenaClientes(lista)

        #Função que mostra o nome dos clientes e seu código
        listarClientesCodigo(listaClientesOrdenada)
        print()
        escolha = input('Deseja analisar as informações de um cliente pelo código?(s/n): ').lower()

        #looping que verifica se opção escolhida é válida, e se for válida e opcao for igual a 'n', uma mensagem
        #é mostrada e retornado 0 saindo assim da função
        while escolha != 's' and escolha != 'n':
            print()
            print('Opção inválida, tente novamente!!')
            print()
            escolha = input('Deseja analisar as informações de um cliente pelo código?(s/n): ').lower()
        if escolha == 's':
            print()
            cod = input('Digite o código do cliente: ')

            #looping que verifica se o código é válido e se não existe nenhum cliente com esse código
            #caso esteja válido, a variável verificador se torna 3 e sai do looping e para
            #de verificar
            verificador = 2
            while verificador != 3:
                verificador = 2
                while not verificaCodigo(cod):
                    print()
                    print('Código inválido, por favor digite novemente')
                    print()
                    cod = input('Digite o código do cliente: ')
                    verificador -= 1
                cod = int(cod)
                if not verificaExistencia(lista, cod):
                    print()
                    print('Codigo do cliente inexistente, por favor digite um válido')
                    print()
                    cod = input('Digite o código do cliente: ')
                    verificador -= 1
                verificador += 1
            print()

            #Função que mostra ao usuário todas os atributos de um cliente a partir do código passado
            listarDadosCliente(int(cod), lista)
    else:
        print()
        print('Nenhum cliente cadastrado, por favor cadastre ao menos um cliente')

#Função que recebe a lista de clientes, um código e retorna o número
#do posição do cliente com aquele código
def buscaCliente(lista, codigo):
    for posicao in range(len(lista)):
        if lista[posicao].get_codigo() == codigo:
            return posicao

#Função que recebe uma lista de clientes e um código e retorna o nome do cliente
#com aquele código
def verificaCliente(lista, codigo):
    for cliente in lista:
        if codigo == cliente.get_codigo():
            return cliente.get_nome()

#Função que recebe um número e verifica se ele pode se tornar um inteiro
def verificaCodigo(numero):
    try:
        numero = int(numero)
        return True
    except:
        return False

#Função que recebe a lista de clientes e uma informação, e precorre a lisra verificando se algum
#cliente tem um atributo igual a variável informacao, se existir, retorna True se não existir
#retorna False
def verificaExistencia(lista, informacao):
    for info in lista:
        if info.get_nome() == informacao:
            return True
        elif info.get_endereco() == informacao:
            return True
        elif info.get_telefone() == informacao:
            return True
        elif info.get_codigo() == informacao:
            return True
    return False

#Função que recebe um nome do cliente e as listas de manutenções agendadas e realizadas,
#caso exista o mesmo nome do cliente passado em alguma manutenção retorna True
#se nçao existir retorna False
def verificaVinculacao(nomeCliente, listaManuReal, listaManuAgen):

    for manutencao in listaManuAgen:
        if manutencao.get_cliente() == nomeCliente:
            return True

    for manutencao in listaManuReal:
        if manutencao.get_cliente() == nomeCliente:
            return True

    return False

#Função principal da aba clientes, que recebe as variáveis, código, as listas
#dos clientes e das manutenções agendadas e realizadas e retorna o código dos clientes
#que pode ter sido alterado durante a execução dessa parte do programa
def menuClientes(listaClientes, codigo, listaManuReal, listaManuAgen):

    #Função que mostra as opções do menu de clientes e retorna a opção escolhida
    opcao = menu()

    #Looping do menu das opções dos clientes
    while opcao != '5':
        if opcao == '1':

            #parte em que se cadastra um novo cliente na lista de clientes
            #e se adiciona +1 a variável codigo que é retornado pela função cadastrar
            codigo += cadastrar(listaClientes, codigo)

            #Comando que salva as alterações que podem ter sido feitas na lista dos clientes no arquivo binário
            listaClientesArquivo(listaClientes)
        elif opcao == '2':

            #Função que edita o atributo de algum cliente
            editar(listaClientes)

            #Comando que salva as alterações que podem ter sido feitas na lista dos clientes no arquivo binário
            listaClientesArquivo(listaClientes)
        elif opcao == '3':

            #Função que exclui algum cliente da lista de clientes
            excluir(listaClientes, listaManuReal, listaManuAgen)

            #Comando que salva as alterações que podem ter sido feitas na lista dos clientes no arquivo binário
            listaClientesArquivo(listaClientes)
        elif opcao == '4':

            #Função que mostra ao usuário os clientes da lista clientes
            listar(listaClientes)
        else: 
            print() 
            print('Opção inválida, tente novamente') 
        opcao = menu()
    return codigo






    