/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.eclipse.persistence.jpa.jpql.parser.CollectionMemberDeclaration;
import org.eclipse.persistence.jpa.jpql.parser.Expression;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoSeccion;
import sv.edu.uesocc.ingenieria.prn335_2017.web.controladores.TipoSeccionFacadeLocal;
@Named
@ViewScoped
public class tipoSeccionBean implements Serializable{
    public tipoSeccionBean() {
    }   
    
    @EJB
    TipoSeccionFacadeLocal tipoSeccion;
    List<TipoSeccion> lista = new ArrayList<>();

    public TipoSeccionFacadeLocal getTipoSeccion() {
        return tipoSeccion;
    }

    public void setTipoSeccion(TipoSeccionFacadeLocal tipoSeccion) {
        this.tipoSeccion = tipoSeccion;
    }

    public List<TipoSeccion> getLista() {
        return lista;
    }

    public void setLista(List<TipoSeccion> lista) {
        this.lista = lista;
    }
    @PostConstruct
    public void llenar(){
        if(lista != null){
            this.lista=tipoSeccion.findAll();
        }else {
            this.lista=Collections.EMPTY_LIST;
        }
    }
    
    
}
