package br.com.teste.api.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.teste.api.model.Contato;
import br.com.teste.api.repositorio.RepositorioContato;
import br.com.teste.api.repositorio.RepositorioContatoSpecification;
import br.com.teste.api.repositorio.filtro.FiltroContato;
import br.com.teste.api.utils.ArquivoUtils;

@Service
@Transactional
public class ContatoService extends AbstractService<Integer, Contato> {

	@Autowired
	private RepositorioContato contatoRepositorio;

	@Autowired
	private RepositorioContatoSpecification contatoRepositorioSpecifications;

	@Autowired
	private ArquivoUtils arquivoUtils;

	@Override
	public RepositorioContato getRepositorio() {
		return this.contatoRepositorio;
	}

	@Override
	public void validarCamposObrigatorios(Contato model) throws Exception {
		super.validarCamposObrigatorios(model);

		if (StringUtils.isEmpty(model.getNome())) {
			throw new Exception("Campo nome é obrigatório!");
		}

		if (StringUtils.isEmpty(model.getCpf())) {
			throw new Exception("Campo cpf é obrigatório!");
		}

	}

	@Override
	public void validarCamposUnitarios(Contato model) throws Exception {
		super.validarCamposUnitarios(model);

		if (this.contatoRepositorioSpecifications.count((root, query, cb) -> {
			return (model.getId() == null ? cb.equal(root.get("cpf"), model.getCpf())
					: cb.and(cb.equal(root.get("cpf"), model.getCpf()), cb.notEqual(root.get("id"), model.getId())));
		}) > 0) {

			throw new Exception("CPF já cadastrado!");
		}

	}

	@Override
	public Contato salvar(Contato model) throws Exception {
		if (model.getImage64() != null) {
			model.setImagem(this.arquivoUtils.convertImagem64ToByteArray(model.getImage64()));
		}
		return super.salvar(model);
	}

	public List<Contato> consulta(FiltroContato filtro) {
		return this.contatoRepositorioSpecifications.findAll(filtro.getSpecification());
	}

	public Resource download(Integer id) throws Exception {
		Contato contato = this.contatoRepositorio.findById(id).get();
		ByteArrayInputStream bais = new ByteArrayInputStream(contato.getImagem());
		InputStreamResource resource = new InputStreamResource(bais);
		return resource;
	}

}
