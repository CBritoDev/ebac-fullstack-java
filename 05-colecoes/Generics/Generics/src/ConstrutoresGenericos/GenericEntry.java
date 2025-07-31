package ConstrutoresGenericos;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */

//<T> de template,e pode-se passar mais de um tipo
public class GenericEntry<T, E> {
    private T data;
    //posso ter atributos fixos ou genericos
    private Long codigo;

    private E desc;

    public GenericEntry(T data, Long codigo, E desc){
        this.data = data;
        this.codigo = codigo;
        this.desc = desc;
    }

    public T getData(){
        return this.data;
    }

    public Long getCodigo(){
        return this.codigo;
    }

    public E getDesc(){
        return this.desc;
    }
}
