internal class ToDoTaskManager {

    private val arrayOfTaskList: ArrayList<TaskList> = arrayListOf()

    fun addNewTaskList(nameTaskList: String): String{
        arrayOfTaskList.add(TaskList(nameTaskList))
        return "Группа задач \"$nameTaskList\" добавлена"
    }

    fun showTaskList(): String {

        var tmpString = arrayOfTaskList.joinToString(separator = "\n"){taskList -> "${taskList.taskName}" }
        // не могу понять как получить в joinToString indexOf каждого элемента чтобы он был в [] ??
        tmpString=""
        arrayOfTaskList.forEachIndexed { index, taskList ->
            tmpString = "$tmpString [${index + 1}] ${taskList.taskName} \n"
        }
        tmpString = tmpString.substring(0, tmpString.length - 1)

        return tmpString
    }

    fun addNewTaskItemInTaskList(index: Int, text: String, priority: Task.Priority) =
        try {
            arrayOfTaskList[index - 1].addTaskItem(text, priority)
        } catch (e: IndexOutOfBoundsException) {
            "${Const.GROUP_NOT_EXIST} ${Const.USE_SHOW_GROUP}"
        } catch (e: Exception) {
            Const.ERROR_COMMON_EXCEPTION
        }

    fun showTaskItemsInTaskList(index: Int) =
         try {
            this.arrayOfTaskList[index-1].getTaskItemsInTaskList()
        } catch (e: IndexOutOfBoundsException){
            Const.GROUP_NOT_EXIST
        } catch (e: Exception){
            Const.ERROR_COMMON_EXCEPTION
        }

    fun changeTaskStatus(indexTaskList: Int, indexTaskItem: Int)=
         try {
            this.arrayOfTaskList[indexTaskList-1].setTaskIsDone(indexTaskItem-1)
        } catch (e: IndexOutOfBoundsException){
            "${Const.TASK_OR_GROUP_NOT_EXIST} ${Const.USE_SHOW_GROUP}"
        } catch (e: Exception){
            Const.ERROR_COMMON_EXCEPTION
        }
}