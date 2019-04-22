internal data class TaskGroup constructor(val taskName: String) {
    private val taskTitle: String = taskName
    private val arrayOfTask: ArrayList<Task> = arrayListOf()

    fun addTask(taskText: String, taskPriority: Task.Priority): String {

        arrayOfTask.add(Task(taskText, taskPriority))
        return "Задача \"$taskText\" добавлена"
    }

    fun getTasksToString(): String {
        var result = "Задачи из списка $taskTitle:\n"
        if (arrayOfTask.isEmpty()) return "$result${Const.EMPTY_GROUP}"

        arrayOfTask.forEachIndexed { index, task ->
            val statusSymbol : Char =  if (task.status) 'V' else 'X'
            result = "$result[${index + 1}] ${task.taskTitle}; Приоритет (${task.taskPriority.value}); Выполнена ($statusSymbol)\n"
        }
        result = result.substring(0, result.length - 1)
        return result
    }

    fun changeTaskStatus(index: Int) =
         try {
            arrayOfTask[index].status = !arrayOfTask[index].status
            Const.CHANGE_STATUS_OK
        } catch (e: IndexOutOfBoundsException){
            "${Const.CHANGE_STATUS_ERROR} ${Const.TASK_NOT_EXIST}"
        } catch (e: Exception){
            Const.ERROR_COMMON_EXCEPTION
        }

    fun delTask(index: Int) =
        try {
            arrayOfTask.remove(arrayOfTask[index])
        //    arrayOfTask.removeAt(index)
            Const.DEL_STATUS_OK
        } catch (e: IndexOutOfBoundsException){
            "${Const.DEL_TASK_ERROR} ${Const.TASK_NOT_EXIST}"
        } catch (e: Exception){
            Const.ERROR_COMMON_EXCEPTION
        }
}
// showGroup 2
// delTask 3