/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclienteswing;

import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author tahnous
 */
public class ClienteMapDAO implements IClienteDAO  {
    
    private final Map<String, Cliente> map;
    
    public ClienteMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(String cpf) {
        Cliente clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
    }

    @Override
    public Cliente consultar(String cpf) {
        return this.map.get(cpf);
    }    
}
