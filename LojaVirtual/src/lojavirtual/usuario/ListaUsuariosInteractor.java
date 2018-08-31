/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtual.usuario;

import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lojavirtual.BaseInteractor;
import lojavirtual.MessageType;
import lojavirtual.data.PersistenceUtil;
import lojavirtual.data.Repository;
import lojavirtual.domain.Usuario;

/**
 *
 * @author etec
 */
public class ListaUsuariosInteractor extends BaseInteractor{

    private final ListaUsuariosView view;
    
    public ListaUsuariosInteractor(ListaUsuariosView view) {
        super(view);
        this.view = view;
    }

    @Override
    protected void runImpl() {
        String nomePraPesquisa = view.getNomeUsuarioPesquisa();
        
        Repository<Usuario, Long> repositorio = PersistenceUtil.getRepositorioUsuario();
        List<Usuario> resultadoPesquisa;
        
        if (nomePraPesquisa != null && !nomePraPesquisa.isEmpty()){
            resultadoPesquisa = repositorio.findAll()
                                           .stream()
                                           .filter(u -> preparaTexto(u.getNome()).startsWith(preparaTexto(nomePraPesquisa)))
                                           .collect(Collectors.toList());
        }
        else{
            resultadoPesquisa = repositorio.findAll();
        }
        
        view.showUsuarios(resultadoPesquisa);
        view.showMessage(MessageType.INFO, String.format("Foram encontrado(s) %d usuários", resultadoPesquisa.size()));
    }
    
    public static String preparaTexto(String s){
        s = s.toUpperCase();
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }
    
}
