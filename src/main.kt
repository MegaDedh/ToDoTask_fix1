var groupIndex: Int = 0

fun main() {
    val ToDoTaskManager = ToDoTaskManager()


    println(Const.GROUP_LIST)
    println(ToDoTaskManager.showTaskList())
    println(Const.HELP_COMMAND)


    var readString: String
    while (true){
        readString = readLine()!!


        // если применять when то такая проверка на наличие подстроки не сработает
        // не могу придумать лаконичную замену
        if (Const.KEY_SHOW_LIST in readString){
            println(Const.GROUP_LIST)
            println(ToDoTaskManager.showTaskList())
        }

        else if (Const.KEY_ADD_GROUP in readString){
            val addName = readString.substringAfter(' ')
            println(ToDoTaskManager.addNewTaskList(addName))
        }

        else if (Const.KEY_SHOW_GROUP in readString){
            try {
                groupIndex = readString.substringAfter(' ').toInt()
                println(ToDoTaskManager.showTaskItemsInTaskList(groupIndex))
            }
            catch (e: NumberFormatException){
                println(Const.INVALID_COMMAND)
            }
            catch (e: Exception){
                println(Const.ERROR_COMMON_EXCEPTION)
            }
        }

        else if (Const.KEY_ADD_TASK in readString){
            println(Const.ENTER_PRIORITY)


            val addName = readString.substringAfter(' ')
            try {
                val priorityInt = readLine()!!.toInt()
                if (priorityInt !in 1..4) {
                    throw IllegalArgumentException(Const.INVALID_PRIORITY)
                }
                val result = ToDoTaskManager.addNewTaskItemInTaskList(groupIndex, addName, setPriority(priorityInt))
                println(result)
            }
            catch (e: NumberFormatException){
                println(Const.INVALID_COMMAND)
            }
            catch (e: IllegalArgumentException){
                println(Const.INVALID_PRIORITY)
            }
            catch (e: Exception){
                println(Const.ERROR_COMMON_EXCEPTION)
            }
        }

        else if (Const.KEY_CHANGE_STATUS in readString){
            try {
                val taskIndex = readString.substringAfter(' ').toInt()
                println(ToDoTaskManager.changeTaskStatus(groupIndex,taskIndex))
            }
            catch (e: NumberFormatException){
                println(Const.INVALID_COMMAND)
            }
            catch (e: Exception){
                println(Const.ERROR_COMMON_EXCEPTION)
            }
        }

        else if (readString==Const.KEY_HELP) println("""
           ${Const.KEY_SHOW_LIST} ${Const.SHOW_LIST}
           ${Const.KEY_ADD_GROUP} ${Const.ADD_GROUP}
           ${Const.KEY_ADD_TASK} ${Const.ADD_TASK}
           ${Const.KEY_SHOW_GROUP} ${Const.SHOW_GROUP}
           ${Const.KEY_CHANGE_STATUS} ${Const.CHANGE_STATUS}
           ${Const.KEY_EXIT} ${Const.EXIT}""".trimIndent())
        else if (readString==Const.KEY_EXIT) break
        else println("${Const.UNKNOWN_COMMAND} ${Const.HELP_COMMAND}")


    }
}

private fun setPriority (priorityNum: Int)
     = when (priorityNum) {
        1 -> Task.Priority.LOW
        2 -> Task.Priority.NORMAL
        3 -> Task.Priority.HIGH
        4 -> Task.Priority.IMMEDIATE
        else -> Task.Priority.UNKNOWN
    }