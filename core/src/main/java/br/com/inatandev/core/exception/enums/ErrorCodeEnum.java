package br.com.inatandev.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalido", "ON-0001"),
    ON0002("Tax Number indisponivel", "ON-0002"),
    ON0003("Email indisponivel", "ON-0003"),
    ON0004("Houve erro na criacao do usuario", "ON-0004"),

    TR0001("Usuario logista nao tem a funcao transferencia disponivel", "TR-0001"),
    TR0002("Saldo indisponivel", "TR-0002"),
    TR0003("Houve um erro ao realizar a transferencia", "TR-0003"),
    TR0004("Transferencia nao autorizada", "TR-0004"),

    TRP0001("Pin invalido", "TRP-0001"),

    WA0001("Carteira nao encontrada", "WA-0001"),

    NO0001("Houve um erro na notiticacao do usuario", "NO-0001"),

    ATH0001("Houve um erro na autenticacao", "ATH-0001"),

    PIN0001("Pin de transacao bloqueado", "PIN-0001"),
    PIN0002("Pin incorreto, %d tentativa(s) restantes", "PIN-0002"),

    ;
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String pin0002GetMessage(Integer attempt){
        return String.format(PIN0002.message, attempt);
    }
}
