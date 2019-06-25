package todolist.youtube.com.codetutor.controller;

import todolist.youtube.com.codetutor.model.MCVModelImplementor;
import todolist.youtube.com.codetutor.view.DataManipulatorViewImplementor;


public class MVCDataManipulationController implements MVCController{

    MCVModelImplementor mvcModel;
    DataManipulatorViewImplementor mvcView;

    public MVCDataManipulationController(MCVModelImplementor mvcModel, DataManipulatorViewImplementor mvcView){
        this.mvcModel = mvcModel;
        this.mvcView = mvcView;
    }

    @Override
    public void onViewLoaded() {
        mvcView.showSelectedToDo();
    }

    public void onRemoveBottonClicked(long id){
       try{
           boolean success = mvcModel.removeToDoItem(id);
           if(success){
               mvcView.updateViewOnRemove();
           }
       }catch (Exception e){
           mvcView.showErrorToast(e.getMessage());
       }

   }

   public void onModifyButtonClicked(long id, String newValue){
       try{
           boolean success = mvcModel.modifyToDoItem(id,newValue);
           if(success){
               mvcView.updateViewOnModify(mvcModel.getToDo(id));
           }
       }catch (Exception e){
           mvcView.showErrorToast(e.getMessage());
       }
   }


}
