/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 18:18:19
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 18:18:19
 * 
 */


package br.com.nordestefomento.jrimum.utilix;

import org.apache.commons.lang.StringUtils;

import br.com.nordestefomento.jrimum.ACurbitaObject;

/**
 * 
 * Esta classe tem a responsábilidade de prover serviços utilitários
 * relacionados a manipulação de <code>Strings</code>
 * 
 * 
 * @author Gabriel Guimarães
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since JMatryx 1.0
 * 
 * @version 1.0
 */
public class Util4String extends ACurbitaObject{

	public static final String WHITE_SPACE = " ";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7425529940068032055L;
	
	/**
	 * Elimina simbolos como:
	 * ><,;.:!*&%+-_<>[]\/
	 * 
	 * @param str String com os símbolos a serem removidos.
	 * @return String sem símbolos.
	 */
	public static String eliminateSymbols(String str){
		
		if(isNotNull(str)){
			
			str = StringUtils.replace(str,"-","");
			str = StringUtils.replace(str,"_","");
			str = StringUtils.replace(str,"=","");
			str = StringUtils.replace(str,"+","");
		    str = StringUtils.replace(str,"%","");
		    str = StringUtils.replace(str,"*","");
		    str = StringUtils.replace(str,"@","");
		    str = StringUtils.replace(str,"#","");
		    str = StringUtils.replace(str,"&","");
		    str = StringUtils.replace(str,":","");
		    str = StringUtils.replace(str,".","");
		    str = StringUtils.replace(str,";","");
		    str = StringUtils.replace(str,",","");
		    str = StringUtils.replace(str,"!","");
		    str = StringUtils.replace(str,"?","");
		    str = StringUtils.replace(str,"(","");
		    str = StringUtils.replace(str,")","");
		    str = StringUtils.replace(str,"{","");
		    str = StringUtils.replace(str,"}","");
		    str = StringUtils.replace(str,"[","");
		    str = StringUtils.replace(str,"]","");
		    str = StringUtils.replace(str,"/","");
		    str = StringUtils.replace(str,"\\","");
		    str = StringUtils.replace(str,">","");
		    str = StringUtils.replace(str,"<","");
		    str = StringUtils.replace(str,"\"","");
		    str = StringUtils.replace(str,"'","");
		    str = StringUtils.replace(str,"`","");
		}
			
		return str;
	}
	
	
	/**
	 * <p>
	 * Remove os zeros iniciais de uma <code>String</code>, seja ela numérica ou não.
	 * </p>
	 * <p>
	 * <code>removeStartWithZeros("00000") => 0</code><br />
	 * <code>removeStartWithZeros("00023") => 23</code><br />
	 * <code>removeStartWithZeros("02003") => 2003</code>
	 * <p>
	 * @param str
	 * @return a string sem zeros inicias ou um único zero.
	 * 
	 * @since 0.2
	 */
		
	public static String removeStartWithZeros(String str){
		String withoutZeros = null; 
		
		if(isNotNull(str)){
			if(StringUtils.startsWith(str, "0")){
				withoutZeros = StringUtils.removeStart(str, "0"); 
				while(StringUtils.startsWith(withoutZeros, "0"))
					withoutZeros = StringUtils.removeStart(withoutZeros, "0");
				
				if(withoutZeros.trim().length() == 0)
					withoutZeros = "0";
			}else
				withoutZeros = str;
		}

		return withoutZeros;
	}
	
	/**
	 * Remove a acentuação do texto, que inclui os acentos:
	 * <ul>
	 * <li>Agudo. ex.: á</li>
	 * <li>Grave. ex.: à</li>
	 * <li>Til. ex.: ã</li>
	 * <li>Trema. ex.: ä</li>
	 * <li>Circunflexo. ex.: â</li>
	 * </ul>
	 * 
	 * e o Cedilha (ç).
	 * <br />
	 * Os acentos são removidos tanto para letras minúsculas como para letras maiúsculas.
	 * 
	 * @param value String com os caracteres a serem removidos.
	 * @return String sem acentuação.
	 */
	public static String eliminateAccent(String value) {
		
		value = StringUtils.replaceChars(value, 'ç', 'c');
				
		value = StringUtils.replaceChars(value, 'á', 'a');
		value = StringUtils.replaceChars(value, 'â', 'a');
		value = StringUtils.replaceChars(value, 'à', 'a');
		value = StringUtils.replaceChars(value, 'ã', 'a');
		value = StringUtils.replaceChars(value, 'ä', 'a');
		
		value = StringUtils.replaceChars(value, 'é', 'e');
		value = StringUtils.replaceChars(value, 'ê', 'e');
		value = StringUtils.replaceChars(value, 'è', 'e');
		value = StringUtils.replaceChars(value, 'ë', 'e');
		
		value = StringUtils.replaceChars(value, 'í', 'i');
		value = StringUtils.replaceChars(value, 'î', 'i');
		value = StringUtils.replaceChars(value, 'ì', 'i');
		value = StringUtils.replaceChars(value, 'ï', 'i');
		
		value = StringUtils.replaceChars(value, 'ó', 'o');
		value = StringUtils.replaceChars(value, 'ô', 'o');
		value = StringUtils.replaceChars(value, 'ò', 'o');
		value = StringUtils.replaceChars(value, 'õ', 'o');
		value = StringUtils.replaceChars(value, 'ö', 'o');

		value = StringUtils.replaceChars(value, 'ú', 'u');
		value = StringUtils.replaceChars(value, 'û', 'u');
		value = StringUtils.replaceChars(value, 'ù', 'u');
		value = StringUtils.replaceChars(value, 'ü', 'u');
		
		value = StringUtils.replaceChars(value, 'Ç', 'C');
		
		value = StringUtils.replaceChars(value, 'Á', 'A');
		value = StringUtils.replaceChars(value, 'Â', 'A');
		value = StringUtils.replaceChars(value, 'À', 'A');
		value = StringUtils.replaceChars(value, 'Ã', 'A');
		value = StringUtils.replaceChars(value, 'Ä', 'A');
		
		value = StringUtils.replaceChars(value, 'É', 'E');
		value = StringUtils.replaceChars(value, 'Ê', 'E');
		value = StringUtils.replaceChars(value, 'È', 'E');
		value = StringUtils.replaceChars(value, 'Ë', 'E');
		
		value = StringUtils.replaceChars(value, 'Í', 'I');
		value = StringUtils.replaceChars(value, 'Î', 'I');
		value = StringUtils.replaceChars(value, 'Ì', 'I');
		value = StringUtils.replaceChars(value, 'Ï', 'I');
		
		value = StringUtils.replaceChars(value, 'Ó', 'O');
		value = StringUtils.replaceChars(value, 'Ô', 'O');
		value = StringUtils.replaceChars(value, 'Ò', 'O');
		value = StringUtils.replaceChars(value, 'Õ', 'O');
		value = StringUtils.replaceChars(value, 'Ö', 'O');

		value = StringUtils.replaceChars(value, 'Ú', 'U');
		value = StringUtils.replaceChars(value, 'Û', 'U');
		value = StringUtils.replaceChars(value, 'Ù', 'U');
		value = StringUtils.replaceChars(value, 'Ü', 'U');
		
		return value;
	}
}
