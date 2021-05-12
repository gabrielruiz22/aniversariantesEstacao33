package application;

import model.Aniversariante;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.EmailUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static util.DataUtils.formatData;
import static util.DataUtils.getData;

public class Program {

    private static final String PATH_FILE_ANIVERSARIANTES = "src\\main\\resources\\testeAniversariantes.xlsx";

    public static void main(String[] args){
        List<Aniversariante> listAniversariantes = new ArrayList<Aniversariante>();
        Date dataAtual = getData();

        try{
            FileInputStream arquivo = new FileInputStream(new File(PATH_FILE_ANIVERSARIANTES));
            XSSFWorkbook validacaoArquivoExcel = new XSSFWorkbook(arquivo);
            XSSFSheet aniversariantesEstacao33 = validacaoArquivoExcel.getSheetAt(0);
            Iterator<Row> rowIterator = aniversariantesEstacao33.iterator();

            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Aniversariante aniversariante = new Aniversariante();
                listAniversariantes.add(aniversariante);

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()){
                        case 0:
                            aniversariante.setNome(cell.getStringCellValue());
                            break;
                        case 1:
                            aniversariante.setDataAniversario(cell.getDateCellValue());
                            break;
                        case 2:
                            aniversariante.setEmail(cell.getStringCellValue());
                            break;
                    }
                }
            }
            arquivo.close();

            for (int i = 0; i < listAniversariantes.size(); i++){
                System.out.println(listAniversariantes.get(i).toString());
                if(formatData(dataAtual).equals(formatData(listAniversariantes.get(i).getDataAniversario()))){
                    System.out.println("igual");
                }
            }

            EmailUtils.enviarEmailComHtml();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
