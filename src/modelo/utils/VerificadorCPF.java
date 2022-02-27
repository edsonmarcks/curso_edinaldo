package modelo.utils;

public class VerificadorCPF {

    private static String cpfInformado;
    private static StringBuilder cpfValidado = new StringBuilder();

    /**
     * Recebe o CPF informado pelo usuário,
     * Quebra em array de CHAR e usa o algoritimo de validação da Receita
     * Validando os verificadores do mesmo, caso o CPF informado seja igual
     * ao gerando pelo algoritimo este é considerado válido.
     * @param cpfInfo
     * @return Boolean
     */
    public static boolean validandoCPF(String cpfInfo) {
        cpfInformado = cpfInfo.replaceAll("-", "").replaceAll("\\.", "");
        System.out.println("cpf: " + cpfInfo);
        System.out.println("cpf sem pontos: " + cpfInformado);
        int[] verificador1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        char[] CPF = cpfInformado.toCharArray();
        int soma = 0;
        for (int i = 0; i < verificador1.length; i++) {
            //
            soma += Integer.parseInt(String.valueOf(CPF[i])) * verificador1[i];
            cpfValidado.append(CPF[i]);
        }
        //System.out.println("SOMA: " + soma);
        //calcular primeiro verificador;
        int aux = soma % 11;
        if (aux < 2) {
            aux = 0;
        } else {
            aux = 11 - aux;
        }
        //adicionado verificador encontrado
        cpfValidado.append(aux);

        //Segundo verificador
        char[] verificador2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < verificador2.length; i++) {
            //
            soma += Integer.parseInt(String.valueOf(CPF[i])) * verificador2[i];
        }
        aux=soma % 11;
        if (aux < 2) {
            aux = 0;
        } else {
            aux = 11 - aux;
        }
        //System.out.println("Segundo verificador: "+aux);
        //adicionado ao cpf validado
        cpfValidado.append(aux);
        
        return cpfInformado.equals(cpfValidado.toString());
    }
}
