package service;

import org.springframework.stereotype.Service;
import domain.Imovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelService {
    ArrayList<Imovel> imoveis = new ArrayList();

    public List buscaTodosImoveis() {
        List imoveisDisponiveis = new ArrayList();
        return imoveisDisponiveis = imoveis.stream().filter(s -> s.isDisponibilidade() == true).collect(Collectors.toList());
    }
}