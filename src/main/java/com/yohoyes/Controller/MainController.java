package com.yohoyes.Controller;

import com.yohoyes.utils.IOUtil;
import com.yohoyes.utils.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * @author yohoyes
 */
public class MainController implements Initializable {
   @FXML
   private TextField fromPath;
   @FXML
   private TextField toPath;
   @FXML
   private Button fromChooser;
   @FXML
   private Button toChooser;
   @FXML
   private ProgressBar process;

   Settings settings = Settings.getSettings();

   @FXML
   public void addFromButtonClick(ActionEvent event) {
      DirectoryChooser dirChooser = new DirectoryChooser();
      dirChooser.setTitle("Open From Path");
      File dir = dirChooser.showDialog(new Stage());
      if(dir != null) {
         settings.setFromPath(dir.getAbsolutePath());
         settings.setToPath(dir.getAbsolutePath());
      }
      updateRes();
   }

   @FXML
   public void addToButtonClick(ActionEvent event) {
      DirectoryChooser dirChooser = new DirectoryChooser();
      dirChooser.setTitle("Open To Path");
      File dir = dirChooser.showDialog(new Stage());
      if(dir != null) {
         settings.setToPath(dir.getAbsolutePath());
      }
      updateRes();
   }

   @FXML
   public void addActionButtonClick(ActionEvent event) {
      ArrayList<File> files = IOUtil.getFiles();
      Iterator<File> iterator = files.iterator();

      process.setVisible(true);
      int i = 0;
      while (iterator.hasNext()) {
          i++;
          IOUtil.move(iterator.next());
          process.setProgress(i/files.size());
      }
      process.setVisible(true);
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
       updateRes();
   }

   private void updateRes() {
      fromPath.setText(settings.getFromPath());
      toPath.setText(settings.getToPath());
   }
}
