package com.example.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.main.dtos.MutanteDTO;
import com.example.main.dtos.StatsDTO;
import com.example.main.entities.Mutante;
import com.example.main.repository.MutanteRepository;

@Service
public class MutanteService {

	private MutanteRepository repository;

	
	//CONSTRUCTOR
	public MutanteService(MutanteRepository repository) {
		this.repository = repository;
	}
	
	
	//MÉTODOS
	//findAll
	@Transactional
	public List<MutanteDTO> findAll() throws Exception {
		
		List<Mutante> personas = repository.findAll();
		List<MutanteDTO> listaDtos = new ArrayList<>();
		
		try {
			for (Mutante p : personas) {
				MutanteDTO dto = new MutanteDTO();
				
				dto.setId(p.getId());
				dto.setNombre(p.getNombre());
				dto.setApellido(p.getApellido());
				dto.setDna(p.getDna());
				dto.setMutacion(p.getMutacion());
				
				listaDtos.add(dto);
			}
			
			return listaDtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	//findById
	@Transactional
	public MutanteDTO findById(int id) throws Exception {
		
		Optional<Mutante> personaOptional = repository.findById(id);
		MutanteDTO dto = new MutanteDTO();
		
		try {
			Mutante persona = personaOptional.get();
			
			dto.setId(persona.getId());
			dto.setNombre(persona.getNombre());
			dto.setApellido(persona.getApellido());
			dto.setDna(persona.getDna());
			dto.setMutacion(persona.getMutacion());
			
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	
	//save
	@Transactional
	public MutanteDTO save(MutanteDTO dto, boolean mutacion) throws Exception {
		
		Mutante persona = new Mutante();
		
		persona.setNombre(dto.getNombre());
		persona.setApellido(dto.getApellido());
		persona.setDna(dto.getDna());
		
		if(mutacion == true) {
			persona.setMutacion("mutante");
		
		} else {
			persona.setMutacion("normal");
		}
		
		
		try {
			persona = repository.save(persona);
			dto.setId(persona.getId());
			dto.setMutacion(persona.getMutacion());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	
	//update
	@Transactional
	public MutanteDTO update(int id, MutanteDTO dto, boolean mutacion) throws Exception {
		
		Optional<Mutante> personaOptional = repository.findById(id);
		
		try {
			Mutante persona = personaOptional.get();
			
			persona.setId(id);
			persona.setNombre(dto.getNombre());
			persona.setApellido(dto.getApellido());
			persona.setDna(dto.getDna());
			
			if(mutacion == true) {
				persona.setMutacion("mutante");
			
			} else {
				persona.setMutacion("normal");
			}
			
			repository.save(persona);
			
			dto.setId(persona.getId());
			dto.setMutacion(persona.getMutacion());
			
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	
	//delete
	@Transactional
	public boolean delete(int id) throws Exception {
		
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
				return true;
				
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	
	//isMutant
	@Transactional
	public boolean isMutant(MutanteDTO dto) throws Exception {
		
		try {
			int size = dto.getDna().length;
			char[][] dnaMatriz = new char [size][size];
		    int contSecuencia = 0;
		    
		    dnaMatriz = cargarMatrizChar(dto.getDna());

	        contSecuencia = secuenciaHorizontal(dnaMatriz, contSecuencia);
	        contSecuencia = secuenciaVertical(dnaMatriz, contSecuencia);
	        contSecuencia = secuenciaOblicua(dnaMatriz, contSecuencia);

	        
	        //COMPROBAR SECUENCIA
	        if (contSecuencia > 1) {
	        	return true;
	        	
	        } else {
	        	return false;
	        }
	       
	        
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	//Cargar matriz
	@Transactional
	public char[][] cargarMatrizChar(String[] array) {
		
		char[][] matriz = new char[array.length][array.length];
			
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				matriz[i] = array[i].toCharArray(); //convertimos el array de String en una matriz de char
			}
		}
			
		return matriz;
	}
	
	
	//Buscar secuencia horizontal
	@Transactional
	public static int secuenciaHorizontal(char[][] matriz, int contSecuencia) {
		
		int cambiarLetra = 0;
        char letra = ' ';
        int contLetrasH = 1;

        do {
            if (contSecuencia > 1) {
                break;
            }

            if (cambiarLetra == 0) {
                letra = 'A';
            } else if (cambiarLetra == 1) {
                letra = 'C';
            } else if (cambiarLetra == 2) {
                letra = 'G';
            } else if (cambiarLetra == 3) {
                letra = 'T';
            }

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length - 1; j++) {

                    if (matriz[i][j] == letra) {
                        if (matriz[i][j] == matriz[i][j + 1]) {
                            contLetrasH++;

                            if (contLetrasH == 4) {
                                contSecuencia++;
                                contLetrasH = 1;

                                if (contSecuencia > 1) {
                                    break;
                                }
                            }

                        } else {
                            contLetrasH = 1;
                        }

                    }

                }
            }

            contLetrasH = 1;
            cambiarLetra++;

        } while (cambiarLetra < 4);
        
		return contSecuencia;
	}
	
	
	//Buscar secuencia vertical
	@Transactional
	public static int secuenciaVertical(char[][] matriz, int contSecuencia) {
			
		int cambiarLetra = 0;
	    char letra = ' ';
	    int contLetrasV = 1;

	    do {
	    	if (contSecuencia > 1) {
	    		break;
	        }

	        if (cambiarLetra == 0) {
	            letra = 'A';
	        } else if (cambiarLetra == 1) {
	            letra = 'C';
	        } else if (cambiarLetra == 2) {
	            letra = 'G';
	        } else if (cambiarLetra == 3) {
	            letra = 'T';
	        }

	        for (int j = 0; j < matriz.length; j++) {
                for (int i = 0; i < matriz.length - 1; i++) {

                    if (matriz[i][j] == letra) {
                        if (matriz[i][j] == matriz[i + 1][j]) {
                            contLetrasV++;

                            if (contLetrasV == 4) {
                                contSecuencia++;
                                contLetrasV = 1;

                                if (contSecuencia > 1) {
                                    break;
                                }
                            }

                        } else {
                            contLetrasV = 1;
                        }
                    }

                }
            }

            contLetrasV = 1;
            cambiarLetra++;

        } while (cambiarLetra < 4);

        return contSecuencia;
	}
	
	
	//Buscar secuencia oblicua
	@Transactional
	public static int secuenciaOblicua(char[][] matriz, int contSecuencia) {
				
		int cantFila = 6;
        int cantCol = 6;

        int fila = 0;
        int col = cantCol - 4;

        int auxFila = fila;
        int auxCol = col;

        int contLetrasO = 1;

        do {
            if (contSecuencia > 1) {
                break;
            }

            if (col == cantCol - 1 && auxCol > 0) {
                fila = 0;
                col = auxCol - 1;
                auxCol = col;
            } else if (fila == cantFila - 1) {
                fila = auxFila + 1;
                col = 0;
                auxFila = fila;

            } else {

                if (matriz[fila][col] == matriz[fila + 1][col + 1]) {
                    contLetrasO++;

                    if (contLetrasO > 3) {
                        contSecuencia++;
                        contLetrasO = 1;

                        if (contSecuencia > 1) {
                            break;
                        }
                    }

                } else {
                    contLetrasO = 1;
                }

                fila++;
                col++;
            }

        } while ((fila == 3 && col == 0) == false);

        return contSecuencia;
	}
		
	
	//Estadísticas de mutantes
	@Transactional
	public StatsDTO stats() throws Exception {
		
		StatsDTO stats = new StatsDTO();
		
		try {
			stats.setContadorHumano(repository.contarHumanos());
			stats.setContadorMutante(repository.contarMutantes());
			stats.setRatio((float)(stats.getContadorMutante())/(float)(stats.getContadorHumano()) );
		
			return stats;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
}
