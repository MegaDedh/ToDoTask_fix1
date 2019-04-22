internal class ToDoTaskManager {

    private val arrayOfTaskGroup: ArrayList<TaskGroup> = arrayListOf()

    fun addTaskGroup(nameTaskList: String): String {
        arrayOfTaskGroup.add(TaskGroup(nameTaskList))
        return "Группа задач \"$nameTaskList\" добавлена"
    }

    fun showTaskGroups(): String {

        // var tmpString = arrayOfTaskGroup.joinToString(separator = "\n"){taskGroup -> "${taskGroup.taskName}" }
        // не могу понять как получить в joinToString indexOf каждого элемента чтобы он был в [] ??
        var tmpString = ""
        arrayOfTaskGroup.forEachIndexed { index, taskList ->
            tmpString = "$tmpString [${index + 1}] ${taskList.taskName} \n"
        }
        tmpString = tmpString.substring(0, tmpString.length - 1)

        return tmpString
    }

    fun addTask(index: Int, text: String, priority: Task.Priority) =
        try {
            arrayOfTaskGroup[index - 1].addTask(text, priority)
        } catch (e: IndexOutOfBoundsException) {
            "${Const.GROUP_NOT_EXIST} ${Const.USE_SHOW_GROUP}"
        } catch (e: Exception) {
            Const.ERROR_COMMON_EXCEPTION
        }

    fun showTasks(index: Int) =
        try {
            this.arrayOfTaskGroup[index - 1].getTasksToString()
        } catch (e: IndexOutOfBoundsException) {
            Const.GROUP_NOT_EXIST
        } catch (e: Exception) {
            Const.ERROR_COMMON_EXCEPTION
        }

    fun changeTaskStatus(indexTaskList: Int, indexTask: Int) =
        try {
            this.arrayOfTaskGroup[indexTaskList - 1].changeTaskStatus(indexTask - 1)
        } catch (e: IndexOutOfBoundsException) {
            "${Const.TASK_OR_GROUP_NOT_EXIST} ${Const.USE_SHOW_GROUP}"
        } catch (e: Exception) {
            Const.ERROR_COMMON_EXCEPTION
        }


    fun delTask(indexTaskList: Int, indexTask: Int) =
        try {
            this.arrayOfTaskGroup[indexTaskList - 1].delTask(indexTask - 1)
        } catch (e: IndexOutOfBoundsException) {
            "${Const.TASK_OR_GROUP_NOT_EXIST} ${Const.USE_SHOW_GROUP}"
        } catch (e: Exception) {
            Const.ERROR_COMMON_EXCEPTION
        }
}