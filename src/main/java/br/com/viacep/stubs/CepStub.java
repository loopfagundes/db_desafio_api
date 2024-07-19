package br.com.viacep.stubs;

import br.com.viacep.dto.CepDto;

public class CepStub {
    private static final CepDto cep = new CepDto();

    public static CepDto getCepStub() {
        cep.setCep("90619-900");
        cep.setLogradouro("Avenida Ipiranga");
        cep.setComplemento("6681");
        cep.setUnidade("Pontifícia Universidade Católica do Rio Grande do Sul");
        cep.setBairro("Partenon");
        cep.setLocalidade("Porto Alegre");
        cep.setUf("RS");
        cep.setIbge("4314902");
        cep.setGia("");
        cep.setDdd("51");
        cep.setSiafi("8801");
        return cep;
    }
}
