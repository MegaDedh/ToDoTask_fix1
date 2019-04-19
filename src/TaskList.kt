internal data class TaskList constructor(val taskName: String) {
    private val taskTitle: String = taskName
    private val arrayOfTaskItems: ArrayList<Task> = arrayListOf()

    fun addTaskItem(taskText: String, taskPriority: Task.Priority): String {

        arrayOfTaskItems.add(Task(taskText, taskPriority))
        return "Задача \"$taskText\" добавлена"
    }

    fun getTaskItemsInTaskList(): String {
        var result = "Задачи из списка $taskTitle:\n"
        if (arrayOfTaskItems.isEmpty()) return "$result${Const.EMPTY_GROUP}"

        arrayOfTaskItems.forEachIndexed { index, task ->
            val statusSymbol : Char =  if (task.status) 'V' else 'X'
            result = "$result[${index + 1}] ${task.taskTitle}; Приоритет (${task.taskPriority.value}); Выполнена ($statusSymbol)\n"
        }
        result = result.substring(0, result.length - 1)
        return result
    }

    fun setTaskIsDone(index: Int) =
         try {
            arrayOfTaskItems[index].status = !arrayOfTaskItems[index].status
            Const.CHANGE_STATUS_OK
        } catch (e: IndexOutOfBoundsException){
            "${Const.CHANGE_STATUS_ERROR} ${Const.TASK_NOT_EXIST}"
        } catch (e: Exception){
            Const.ERROR_COMMON_EXCEPTION
        }
}