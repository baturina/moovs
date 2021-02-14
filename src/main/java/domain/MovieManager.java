package domain;



public class MovieManager{


    private MovieItem[] items = new MovieItem[0];
    private int length = 10;
    private int custom;
    //В менеджер добавляем пустой консруктор
    public MovieManager(int custom) {
        this.custom = custom;
    }
    public MovieManager() {}




    public void add(MovieItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);

        //System.arraycopy(items, 0, tmp, 0, items.length); //items.length
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }


    public MovieItem[] getAll() {
        int temp = items.length; //создаём новую переменную temp, которая равна длинне основного массива

        if (custom <= 0) {  // если не введено колличество фильмов
            if (length < temp ) {  // если основной массив меньше 10

                temp = length; //  выводится 10
            }
        } else { // в противном случае
            if (custom < temp) { // если введенное количество < дл. массива
                temp = custom; // дл. массива = введен.колич.
            }
        }
        MovieItem[] result = new MovieItem[temp]; // создаем новый массив result,куда складываем фильмы в обратном порядке
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
