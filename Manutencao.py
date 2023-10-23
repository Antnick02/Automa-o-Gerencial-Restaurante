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
from datetime import datetime, timedelta, date
from dateutil.relativedelta import relativedelta
from Cliente import *
from pickle import dump, load
import copy

#Definição e criação da classe Manuntencao para criação dos objetos
class Manuntencao:
    def __init__(self, codigo, preco, cliente, nomePeca, data, prazo, periodo):
        self.codigo = int(codigo) + 1
        self.preco = float(preco)
        self.cliente = cliente
        self.nomePeca = nomePeca
        self.data = data
        self.prazo = int(prazo)
        self.periodo = periodo

    #Funções que retornam os atributos do objeto
    def get_codigo(self):
        return self.codigo

    def get_preco(self):
        return self.preco

    def get_cliente(self):
        return self.cliente

    def get_nomePeca(self):
        return self.nomePeca

    def get_data(self):
        return self.data

    def get_prazo(self):
        return self.prazo

    def get_periodo(self):
        return self.periodo

    #Funções que modificam alguns atributos do objeto
    def set_preco(self, novoPreco):
        self.preco = novoPreco

    def set_nomePeca(self, novoNomePeca):
        self.nomePeca = novoNomePeca

    def set_data(self, novaData):
        self.data = novaData

    def set_prazo(self,novoPrazo):
        self.prazo = novoPrazo

    def set_periodo(self, novoPeriodo):
        self.periodo = novoPeriodo

    def set_codigo(self, novocodigo):
        self.codigo = novocodigo

    def set_cliente(self, novocliente):
        self.cliente = novocliente

#Função que pega os dados do arquivo binário e passa para uma variável e a retorna
def arquivoManuRealLista():
    with open('manutencoesRealizadas.dat', 'rb') as arquivo:
        lista = load(arquivo)
    return lista

#Função que recebe uma lista e retorna um valor para o código a partir da lista recebida
def obtemCodigoManuReal(lista):
    if lista == []:
        return 0
    else:
        codigo = lista[-1].get_codigo()
        return codigo + 1

#Função que pega os dados do arquivo binário e passa para uma variável e a retorna
def arquivoManuAgenLista():
    with open('manutencoesAgendadas.dat', 'rb') as arquivo:
        lista = load(arquivo)
    return lista

#Função que recebe uma lista e retorna um valor para o código a partir da lista recebida
def obtemCodigoManuAgen(lista):
    if lista == []:
        return 0
    else:
        codigo = lista[-1].get_codigo()
        return codigo + 1

#Função que pega os dados da lista que recebe e passa para o arquivo binário
def listaManuAgenArquivo(lista):
    if lista:
        with open('manutencoesAgendadas.dat', 'wb') as arquivo:
            dump(lista, arquivo)
    else:
        with open('manutencoesAgendadas.dat', 'wb') as arquivo:
            dump([], arquivo)

#Função que pega os dados da lista que recebe e passa para o arquivo binário
def listaManuRealArquivo(lista):
    if lista:
        with open('manutencoesRealizadas.dat', 'wb') as arquivo:
            dump(lista, arquivo)
    else:
        with open('manutencoesRealizadas.dat', 'wb') as arquivo:
            dump([], arquivo)

#Função que mostra as opções do menu da aba manutenções e retorna a opção escolhida
def menu():
    print(''' 
Menu Manutenções!!! 

[1]Agendar manutenção
[2]Editar manutenção
[3]Realizar manutenção
[4]Excluir manutenção
[5]Listar manutenções
[6]Imprimir manutenções
[7]Sair 
''')
    opcao = input('Escolha uma opção: ')
    return opcao

#Função que recebe preço e verifica se ele pode se tornar um float
def verificaPreco(preco):
    try:
        preco = float(preco)
        return True
    except:
        return False

#Função que mostra as opções do menu do periodo e retorna a opção escolhida
def menuPeriodo():
    print(''' 
Digite o formato do período de tempo que irá utilizar para o prazo de validade:

[1]Dia(s) 
[2]Mês(es) 
[3]no(s)
''')
    periodo = input(' ').lower().strip()
    return periodo

#Função que recebe prazo e verifica se ele pode se tornar um inteiro
def verificaPrazo(prazo):
    try:
        prazo = int(prazo)
        return True
    except:
        return False

#Recebe uma string e verifica se ela pode se tornar uma data, caso possa e data não seja
#anterior ou igual a data atual, retorna True, caso contrário retorna False
def verificaData(data):
    try:

        #parte que tenta transformar a string em data
        valorData = datetime.strptime(data, '%d/%m/%Y').date()

        #Aqui se obtém a data do dia atual
        dataAtual = date.today()

        #Verificação se não é uma data anterior ou igual a data atual
        if valorData <= dataAtual:
            return False
        return True
    except:
        return False

#Função que recebe as listas de clientes e manutenções agendadas, junto com o código das manutenções
#e agenda uma nova manutenção, adicionando o objeto da classe Manuntencao na variável listaManuAgen
def agendar(listaManuAgen, listaClientes, codigo):

    #Verificação se a lista de clientes não está vazia, impossibilitando assim a criação de uma nova manutenção
    #caso esteja mostra um aviso indicando isso e retorna 0
    if listaClientes:

        #parte em que os dados da manutenção são adicionados
        print()
        print('Digite as informações da manutenção')
        print()
        nomePeca = input('Digite o nome da peça da manutenção: ').title()
        print()
        preco = input('Digite o preço da peça da manutenção(Ex: 1.50): ')

        #looping que verifica se o preço é válido(pode se tornar um float)
        while not verificaPreco(preco):
            print()
            print('Preço inválido!!, por favor digite novamente')
            print()
            preco = input('Digite o preço da peça da manutenção: ')

        print()

        #Parte que mostra as opções do menu em que vc escolhe o periodo do prazo de validade
        #podendo ser dia, mês ou ano e retornando a opção escolhida atribuindo a variável periodo
        periodo = menuPeriodo()

        #looping que verifica se as opção escolhida e atribuida e periodo, foi válida
        while periodo != '1' and periodo != '2' and periodo != '3':
            print()
            print('Período inválido!!, por favor digite um formato válido')
            periodo = menuPeriodo()

        #A partir do que foi escolhido para periodo, a variável periodo é modificada
        #podendo receber essas palavras
        if periodo == '1':
            periodo = 'dia(s)'
        elif periodo == '2':
            periodo = 'mes(es)'
        elif periodo == '3':
            periodo = 'ano(s)'

        print()
        prazo = input('Digite o prazo de validade da peça a partir do período que indicou: ')

        #looping que verifica se o prazo passado pode se tornar inteiro
        while not verificaPrazo(prazo):
            print()
            print('Prazo inválido, por favor digite novamente')
            print()
            prazo = input('Digite o prazo de validade da peça a partir do período que indicou: ')

        print()
        data = input('Digite a data para a realização da 1°manutenção, neste formato (00/00/0000): ').strip()

        #looping que verifica se o string passsado pode se tornar uma data, algo que só pode ser feito se seguir
        #o formata passado e ser uma data posterior a atual
        while not verificaData(data):
            print()
            print('Data inválida, por favor siga o formato apresentado e confira se a data não é menor ou igual a data atual')
            print()
            print('Exemplo: 02/05/2022 ')
            print()
            data = input('Digite a data: ').strip()

        print()
        cliente = input('Digite o código do cliente desta manutenção: ')

        #looping que verifica se o código é válido e se não pertence a nenhum cliente
        #caso esteja válido, a variável verificador se torna 3 e sai do looping e para
        #de verificar
        verificador = 2
        while verificador != 3:
            verificador = 2
            while not verificaCodigo(cliente):
                print()
                print('Código inválido, por favor digite novamente')
                print()
                cliente = input('Código do cliente:')
                verificador -= 1
            cliente = int(cliente)
            if not verificaExistencia(listaClientes, cliente):
                print()
                print('Código inexistente , por favor digite um código válido e existente')
                print()
                cliente = input('Digite o código do cliente desta manutenção: ')
                verificador -= 1
            verificador +=1

        #A variável cliente recebe o nome do cliente através da função verificaCliente que retorna um nome
        cliente = verificaCliente(listaClientes, cliente)
        print()

        #Comando que mostra o nome do cliente do código escolhido e pergunta ao usário se o cliente mostrado
        #é aquele que quer vincualr a amanutenção
        opi = input('{0} é o cliente que quer vincular a esta manutenção?(s/n): '.format(cliente)).lower()

        #looping que verifica se opção escolhida é válida, e se for válida e opcao for igual a 'n', uma mensagem
        #é mostrada e retornado 0 saindo assim da função
        while opi != 's' and opi != 'n':
            print()
            print('Opção inválida digite novamente')
            print()
            opi = input(
                '{0} é o cliente que quer vincular a esta manutenção?(s/n): '.format(cliente)).lower()
        if opi == 'n':
            print()
            print('Verifique as informações e tente novamente')
            return 0

        #Criação do objeto da classe Manuntencao e o adicionando na lista de manutenções agendadas
        listaManuAgen.append(Manuntencao(codigo, float(preco), cliente, nomePeca, data, int(prazo), periodo))
        print()
        print('Manutenção Agendada!!!')
        return 1
    else:
        print()
        print('Nenhum cliente cadastrado, por favor cadastre ao menos um cliente para agendar a manutenção')
        return 0

#Menu da parte do programa de editar que mostra as opções
#e retorna a opção escolhida
def menuEditar():
    print(''' 
Informações da Manutenção 

[1]Nome da peça 
[2]Custo 
[3]Data 
[4]Prazo de validade da peça 
[5]Cliente
[6]Sair

''')
    opcao = input('O que deseja editar?: ')
    return opcao

#Função recebe as lista de manuntenções agendadas e realizadas, junto com um código
#e percorre as listas verificandos e existe alguma manutenção com o mesmo código que foi passado
#caso encontre retorna-se esse objeto
def verificaManu(listaManuAgen, listaManuReal, codigo):
    for manutencao in listaManuReal:
        if manutencao.get_codigo() == codigo:
            return manutencao
    for manutencao in listaManuAgen:
        if manutencao.get_codigo() == codigo:
            return manutencao

#Função recebe as lista de manuntenções agendadas e realizadas, e uma provável manutenção,
#caso mostra para o usuário os dados das manutenções ou a única manutenção a partir de condições
#especificas
def listarManutencoes(listaManuAgen,listaManuReal,manutencao):

    #Se manutencao for válida é mostrada apenas seus dados
    if manutencao:
        print()
        print('[{0}] - Peça:{1:<15} Custo:R${2:<5} Data:{3:<9}  Cliente:{4:<10} Prazo:{5:3}{6}'.format(manutencao.get_codigo(),
        manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
        manutencao.get_prazo(), manutencao.get_periodo()))
    elif listaManuAgen and listaManuReal:
        #Caso as lista de manuntenções agendadas e realizadas sejam válidas, as duas são percorridas
        #mostrando todas suas manutenções e seus dados
        print()
        print('{0:^76}'.format('Manutenções Realizadas'))
        for manutencao in listaManuReal:
            print()
            print('[{0}] - Peça:{1:<10} Custo:R${2:<5} Data:{3:<9}  Cliente:{4:<10} Prazo:{5:3} {6}'.format(
                manutencao.get_codigo(),
                manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                manutencao.get_prazo(), manutencao.get_periodo()))
        print()
        print('{0:^76}'.format('Manutenções Agendadas'))
        for manutencao in listaManuAgen:
            print()
            print('[{0}] - Peça:{1:<10} Custo:R${2:<5} Data:{3:<9}  Cliente:{4:<10} Prazo:{5:3} {6}'.format(
                manutencao.get_codigo(),
                manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                manutencao.get_prazo(), manutencao.get_periodo()))
    elif listaManuAgen and not listaManuReal:
        #Caso as lista de manuntenções agendadas seja válida e realizadas não, apenas a lista das agendadas é percorrida
        #mostrando todas suas manutenções e seus dados
        print()
        print('{0:^76}'.format('Manutenções Agendadas'))
        for manutencao in listaManuAgen:
            print()
            print('[{0}] - Peça:{1:<10} Custo:R${2:<5} Data:{3:<9} Cliente:{4:<10} Prazo:{5:3} {6}'.format(
                manutencao.get_codigo(),
                manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                manutencao.get_prazo(), manutencao.get_periodo()))
    elif listaManuReal and not listaManuAgen:
        #Caso as lista de manuntenções realizadas seja válida e agendadas não, apenas a lista das realizadas é percorrida
        #mostrando todas suas manutenções e seus dados
        print()
        print('{0:^76}'.format('Manutenções Realizadas'))
        for manutencao in listaManuReal:
            print()
            print('[{0}] - Peça:{1:<10} Custo:R${2:<5} Data:{3:<9} Cliente:{4:<10} Prazo:{5:3} {6}'.format(
                manutencao.get_codigo(),
                manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                manutencao.get_prazo(), manutencao.get_periodo()))
    else:
        #caso nenhuma dessas condições sejam atendidas é mostrado um aviso
        print()
        print('Nenhuma manutenção encontrada, agende pelo menos uma para ser mostrada!!!')

#Função recebe as lista de manuntenções agendadas e realizadas e lista de clientes
#e modifica algum atributo do objeto da manutenção
def editar(listaManuAgen, listaManuReal, listaClientes):

    #Se alguma das listas de manutenções agendadas ou realizadas for
    #válida(Não estiver vazia) continua o programa e caso as duas estejam
    #vazias um aviso é msotrado
    if listaManuAgen or listaManuReal:
        print()
        codigo = input('Digite o código da manutenção que quer alterar: ')

        #looping que verifica se o código é válido e se não pertence a nenhuma manutenção
        #caso esteja válido, a variável verificador se torna 3 e sai do looping e para
        #de verificar
        verificador = 2
        while verificador != 3:
            verificador = 2
            while not verificaCodigo(codigo):
                print()
                print('Código inválido, por favor digite novamente')
                print()
                codigo = input('Código da manutenção:')
                verificador -= 1
            codigo = int(codigo)
            if not verificaManu(listaManuAgen, listaManuReal, codigo):
                print()
                print('Código inexistente , por favor digite um código válido e existente')
                print()
                cliente = input('Digite o código da manutenção: ')
                verificador -= 1
            verificador += 1

        #Atribui a variável manutencao, a manutenção encontrada pela função verificaManu
        #pelo código
        manutencao = verificaManu(listaManuAgen, listaManuReal, codigo)

        #Função que mostra ao usuário, a manutenção encontrada e pede para
        #o usuário que se confirme se aquela é a manutenção que quer editar
        #caso não seja um avisó é mostrado e retorna 0 para sair da função
        listarManutencoes(0, 0, manutencao)
        print()
        opi = input('Esta é a manutenção que quer editar??(s/n): ').lower()
        while opi != 's' and opi != 'n':
            print()
            print('Opção inválida digite novamente')
            print()
            opi = input(
                'Esta é a manutenção que quer editar??(s/n): ').lower()
        if opi == 'n':
            print()
            print('Verifique as informações e tente novamente')
            return 0

        #Parte responsável por mostrar as opções do menu e atribui a variável opcao
        #a opcao escolhida
        opcao = menuEditar()

        #Looping do menu editar, que pela opção ecolhida, é modificado o atributo do manutenção
        #passada, a partir do dado inserido pelo usuário que é verificado pelo programa,
        #certo atributo do objetoé trocado pela função set e ocorre um break saindo do
        #looping do menu editar e saindo da função
        while opcao != '6':
            if opcao == '1':
                print()
                nomePeca = input('Digite o novo nome da peça: ')
                manutencao.set_nomePeca(nomePeca)
                break
            elif opcao == '2':
                print()
                preco = input('Digite o novo preço ex(18.25):')
                while not verificaPreco(preco):
                    print()
                    print('Preço inválido!!, por favor digite novamente')
                    print()
                    preco = input('Digite o preço da peça da manutenção: ')
                manutencao.set_preco(preco)
                break
            elif opcao == '3':
                print()
                data = input('Digite a nova data respeitando o formato(00/00/0000): ').strip()
                print()
                while not verificaData(data):
                    print()
                    print('Data inválida, por favor siga o formato apresentado e confira se a data não é menor ou igual a data atual')
                    print()
                    print('Exemplo: 02/05/2019 ')
                    print()
                    data = input('Digite a data: ').strip()
                manutencao.set_data(data)
                break
            elif opcao == '4':
                print()
                periodo = menuPeriodo()
                while periodo != 'd' and periodo != 'm' and periodo != 'a':
                    print()
                    print('Período inválido!!, por favor digite um formato válido')
                    periodo = menuPeriodo()

                if periodo == '1':
                    periodo = 'dia(s)'
                elif periodo == '2':
                    periodo = 'mes(es)'
                elif periodo == '3':
                    periodo = 'ano(s)'

                manutencao.set_periodo(periodo)
                print()
                prazo = input('Digite o novo prazo de validade da peça a partir do período que indicou: ')
                while not verificaPrazo(prazo):
                    print()
                    print('Prazo inválido, por favor digite novamente')
                    print()
                    prazo = input('Digite o prazo de validade da peça a partir do período que indicou: ')
                manutencao.set_prazo(prazo)
                break
            elif opcao == '5':
                print()
                cliente = input('Digite o código do cliente desta manutenção: ')
                verificador = 2
                while verificador != 3:
                    verificador = 2
                    while not verificaCodigo(cliente):
                        print()
                        print('Código inválido, por favor digite novamente')
                        print()
                        cliente = input('Código do cliente:')
                        verificador -= 1
                    cliente = int(cliente)
                    if not verificaExistencia(listaClientes, cliente):
                        print()
                        print('Código inexistente , por favor digite um código válido e existente')
                        print()
                        cliente = input('Digite o código do cliente desta manutenção: ')
                        verificador -= 1
                    verificador += 1
                cliente = verificaCliente(listaClientes, cliente)
                print()
                opi = input('{0} é o cliente que quer vincular a esta manutenção?(s/n): '.format(cliente)).lower()
                while opi != 's' and opi != 'n':
                    print()
                    print('Opção inválida digite novamente')
                    print()
                    opi = input(
                        '{0} é o cliente que quer vincular a esta manutenção?(s/n): '.format(cliente)).lower()
                if opi == 'n':
                    print()
                    print('Verifique as informações e tente novamente')
                    return 0
                manutencao.set_cliente(cliente)
                break
            else:
                print()
                print('Opcão inválida, tente novamente')
            opcao = menuEditar()
    else:
        print()
        print('Nenhuma manutenção encontrada, agende ao menos uma manutenção para poder edita-lá!!!')

#Função recebe as lista de manutenções agendadas e realizadas, uma manutenção e código
#e partir da manutenção agendada encontrada ela é passada para lista de manutenções realizadas
#e esta manutenção agendada, é modificada, recebendo um novo código, e uma nova data
def realizar(listaManuAgen, listaManuReal, manutencao, cod):

    #Parte que verifica se a manutenção passada esta na lista de manutenções realizadas
    #caso esteja um aviso é mostrado, devido ao fato de não ser possível realizar uma manutenção
    #já realizada e retorna 0 e sai da função
    if manutencao in listaManuReal:
        print()
        print('Código de uma manutenção realizada')
        print()
        print('Só é possível realizar uma manutenção agendada!!!')
        return 0

    #A partir da manutenção recebida verifica onde ela se encontra na lista de manutenções
    #agendadas e define sua posição atribuindo o seu número a variável posicao
    for i in range(len(listaManuAgen)):
        if manutencao == listaManuAgen[i]:
            posicao = i

    #Adiciona a lista de manutenções realizadas uma copia do objeto
    #manutenção que foi encontrado na lista de manutenções agendadas
    #pela posição passada
    listaManuReal.append(copy.copy(listaManuAgen[posicao]))

    #Função que atribui a variável data o string data da manutencao
    data = manutencao.get_data()

    #Função que transforma a variável data que é uma string no atributo data
    data = datetime.strptime(data, '%d/%m/%Y').date()

    #A partir do periodo da manutencao passado, vão ser adicionados dias,
    #meses ou anos a data obtida

    if manutencao.get_periodo() == 'dia(s)':
        #Atribui a variável prazo o valor de prazo da manutenção
        prazo = manutencao.get_prazo()
        #Atribui a variável data nova a data antiga somada com os dias
        #representados pelo valor do prazo
        datanova = (data + timedelta(days=prazo))
        #Pega a variável datanova com atributo de data, e a converte para
        #o formato de string
        data = datetime.strftime(datanova, '%d/%m/%Y')
        #Funções que alteram o valor de alguns atributos da manutenção
        manutencao.set_data(data)
        manutencao.set_codigo(cod + 1)
    elif manutencao.get_periodo() == 'mes(es)':
        #Atribui a variável prazo o valor de prazo da manutenção
        prazo = manutencao.get_prazo()
        #Atribui a variável data nova a data antiga somada com os meses
        #representados pelo valor do prazo
        datanova = (data + relativedelta(months=prazo))
        data = datetime.strftime(datanova, '%d/%m/%Y')
        manutencao.set_data(data)
        manutencao.set_codigo(cod + 1)
    elif manutencao.get_periodo() == 'ano(s)':
        # Atribui a variável prazo o valor de prazo da manutenção
        prazo = manutencao.get_prazo()
        #Atribui a variável data nova a data antiga somada com os anos
        #representados pelo valor do prazo
        datanova = (data + relativedelta(years=prazo))
        datanova = datetime.strftime(datanova, '%d/%m/%Y')
        manutencao.set_data(datanova)
        manutencao.set_codigo(cod + 1)

#Função recebe as lista de manutenções agendadas e realizadas, e um código
#e faz a verificação dos dados para que a manutenção seja realizada
def realizarManu(listaManuAgen, listaManuReal, cod):

    #Caso a lista de manutenções agendadas esteja vazia, não segue com o bloco de instruções
    #e um aviso é mostrado
    if listaManuAgen:
        print()
        codigo = input('Digite o código da manutenção que quer realizar: ')

        #looping que verifica se o código é válido e se não pertence a nenhuma manutenção
        #caso esteja válido, a variável verificador se torna 3 e sai do looping e para
        #de verificar
        verificador = 2
        while verificador != 3:
            verificador = 2
            while not verificaCodigo(codigo):
                print()
                print('Código inválido, por favor digite novamente')
                print()
                codigo = input('Código da manutenção:')
                verificador -= 1
            codigo = int(codigo)
            if not verificaManu(listaManuAgen, listaManuReal, codigo):
                print()
                print('Código inexistente , por favor digite um código válido e existente')
                print()
                codigo = input('Digite o código da manutenção: ')
                verificador -= 1
            verificador += 1

        #Atribui a variável manutencao, a manutenção encontrada pela função verificaManu
        #pelo código
        manutencao = verificaManu(listaManuAgen, listaManuReal, codigo)

        #Função que mostra ao usuário, a manutenção encontrada e pede para
        #o usuário que se confirme se aquela é a manutenção que quer editar
        #caso não seja um avisó é mostrado e retorna 0 para sair da função
        listarManutencoes(0, 0, manutencao)
        print()
        opi = input('Esta é a manutenção que quer realizar??(s/n): ').lower()
        while opi != 's' and opi != 'n':
            print()
            print('Opção inválida digite novamente')
            print()
            listarManutencoes(0, 0, manutencao)
            print()
            opi = input(
                'Esta é a manutenção que quer editar??(s/n): ').lower()
            if opi == 'n':
                print()
                print('Verifique as informações e tente novamente')
                return 0

        #Função que realiza certa manutenção agendada, mostra o aviso para o usuário
        #e retorna 1
        realizar(listaManuAgen, listaManuReal, manutencao, cod)
        print()
        print('Manutenção realizada!!!')
        return 1
    else:
        print()
        print('Nenhuma manutenção agendada, agende pelo menos uma para poder realiza-la!!!')
        return 0

#Função recebe as lista de manutenções agendadas e realizadas, e uma manutenção,
#a partir da manutenção passada procura-se uma manutenção correspondente em alguma
#das listas e ao encontrar atribui a variável posicao o número da posição correspondente
#desta manutenção
def excluir(listaManuAgen, listaManuReal, manutencao):
    manu = 0
    for i in range(len(listaManuAgen)):
        if manutencao == listaManuAgen[i]:
            posicao = i
            manu += 1

    for i in range(len(listaManuReal)):
        if manutencao == listaManuReal[i]:
            posicao = i

    #Caso a manu receba +1 indica que a manutenção, foi encontrada na lista
    #de manutenções agendadas caso contrário foi encontrada da lista de manutenções
    #realizadas, e a partir disso ela é removida de sua lista correspondente
    if manu == 1:
        listaManuAgen.pop(posicao)
    else:
        listaManuReal.pop(posicao)

#Função recebe as lista de manutenções agendadas e realizadas,
#e faz a verificação dos dados para que a manutenção seja realizada
def excluirManu(listaManuAgen, listaManuReal):
    if listaManuAgen or listaManuReal:
        print()
        codigo = input('Digite o código da manutenção que quer excluir: ')
        verificador = 2
        while verificador != 3:
            verificador = 2
            while not verificaCodigo(codigo):
                print()
                print('Código inválido, por favor digite novamente')
                print()
                codigo = input('Código da manutenção:')
                verificador -= 1
            codigo = int(codigo)
            if not verificaManu(listaManuAgen, listaManuReal, codigo):
                print()
                print('Código inexistente , por favor digite um código válido e existente')
                print()
                codigo = input('Digite o código da manutenção: ')
                verificador -= 1
            verificador += 1
        manutencao = verificaManu(listaManuAgen, listaManuReal, codigo)
        listarManutencoes(0, 0, manutencao)
        print()
        opi = input('Esta é a manutenção que quer excluir??(s/n): ').lower()
        while opi != 's' and opi != 'n':
            print()
            print('Opção inválida digite novamente')
            print()
            listarManutencoes(0, 0, manutencao)
            print()
            opi = input('Esta é a manutenção que quer excluir??(s/n): ').lower()
        if opi == 'n':
            print()
            print('Verifique as informações e tente novamente')
            return 0
        excluir(listaManuAgen, listaManuReal, manutencao)
        print()
        print('Manutenção excluida com sucesso!!!')
    else:
        print()
        print('Nenhuma manutenção existente para ser excluída!!!')

#Função que recebe as lista de manutenções agendadas,
#e devolve uma lista ordenada pela data mais recente
#utilizando a ideia de ordenação por seleção
def ordenaManuAgen(listaManuAgen):
    #copia a lista recebida
    copiaLista = listaManuAgen.copy()
    if len(copiaLista) == 1:
        return listaManuAgen
    else:
        for i in range(0, len(copiaLista) - 1):
            min = i
            for j in range(i + 1, len(copiaLista)):
                #Atribui tranformas as datas strings em datas com atributo de data para serem comparadas
                data_1 = datetime.strptime(copiaLista[j].get_data(), '%d/%m/%Y').date()
                data_2 = datetime.strptime(listaManuAgen[min].get_data(), '%d/%m/%Y').date()
                if data_1 < data_2:
                    min = j
            copiaLista[i], copiaLista[min] = copiaLista[min], copiaLista[i]
    return copiaLista

#Função recebe a lista de manutenções agendadas e cria um
#arquivo txt contendo as manutenções agendadas de forma formatada
def imprimirManuntencoes(listaManuAgen):

    if listaManuAgen:
        manuOrdenadas = ordenaManuAgen(listaManuAgen)
        with open('ImpressaoManutencoesAgendadas.txt', 'w') as arquivo:
            arquivo.write('{0:^76}\n'.format('Manutenções Agendadas'))
            arquivo.write('{0:<6} | {1:^10} | {2:^7} | {3:^9} | {4:^10} | {5:^5} | {6:^7}'.format('Código', 'Peça', 'Custo', 'Data', 'Cliente', 'Prazo', 'Periodo'))
            arquivo.write('\n')
            for manutencao in manuOrdenadas:
                arquivo.write('{0:^6} | {1:^10} | R${2:^5} |{3:^9} | {4:^10} | {5:^5} | {6:^7}\n'.format(
                    manutencao.get_codigo(),
                    manutencao.get_nomePeca(), manutencao.get_preco(), manutencao.get_data(), manutencao.get_cliente(),
                    manutencao.get_prazo(), manutencao.get_periodo()))
        print()
        print('Manutenções impressas!!!')
    else:
        print()
        print('Nenhuma Manutenção agendada!!!')

#Função principal da aba manutenção, que recebe as variáveis, código, as listas
#dos clientes e das manutenções agendadas e realizadas e retorna o código das manutenções
#que pode ter sido alterado durante a execução dessa parte do programa
def menuManu(listaManuAgen, listaManuReal, listaClientes, codigo):

    # Função que mostra as opções do menu de manutenções e retorna a opção escolhida
    opcao = menu()

    # Looping do menu das opções das manutenções
    while opcao != '7':
        if opcao == '1':

            #Parte em que se agenda uma nova manutenção na lista de manutenções agendadas
            #e se adiciona +1 a variável codigo que é retornado pela função agendar
            codigo += agendar(listaManuAgen, listaClientes, codigo)

            #Comando que salva as alterações que podem ter sido feitas na lista
            #de manutenções agendadas no arquivo binário
            listaManuAgenArquivo(listaManuAgen)
        elif opcao == '2':

            #Função que edita o atributo de alguma manutenção
            editar(listaManuAgen, listaManuReal, listaClientes)

            #Comandos que salvam as alterações que podem ter sido feitas na lista
            #de manutenções agendadas  e realizadas no arquivo binário
            listaManuAgenArquivo(listaManuAgen)
            listaManuRealArquivo(listaManuReal)
        elif opcao == '3':

            #Função que realiza uma manutenção agendada e passa para lista de
            #manutenções realizadas e retorn açgum valor para ser adicionado ao código
            codigo += realizarManu(listaManuAgen, listaManuReal, codigo)

            #Comandos que salvam as alterações que podem ter sido feitas na lista
            #de manutenções agendadas  e realizadas no arquivo binário
            listaManuAgenArquivo(listaManuAgen)
            listaManuRealArquivo(listaManuReal)
        elif opcao == '4':

            # Função que exclui alguma manutenção de alguma das listas de manutenções
            excluirManu(listaManuAgen, listaManuReal)

            #Comandos que salvam as alterações que podem ter sido feitas na lista
            #de manutenções agendadas  e realizadas no arquivo binário
            listaManuAgenArquivo(listaManuAgen)
            listaManuRealArquivo(listaManuReal)
        elif opcao == '5':

            #Função que mostra ao usuário as manutenções da lista de manutenções
            listarManutencoes(listaManuAgen, listaManuReal, 0)
        elif opcao == '6':

            #Função que recebe a lista de manutenções agendadas e as imprime em um arquivo txt
            #de forma formatada
            imprimirManuntencoes(listaManuAgen)
        else:
            print()
            print('Opção inválida, tente novamente!!')
        opcao = menu()
    return codigo
