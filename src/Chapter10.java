import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		// 以下記述
		long ta = list.stream()
				.filter(t1 -> t1.isDone() == false)
				.count();
		System.out.println("未完了のタスクの個数は" + ta);
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");

		list.stream()
		        .filter(t1 -> t1.isDone() == false)
		        .sorted()
		        .forEach(System.out::println);
	}

}

/*
 * 実行結果の表示に含まれる内容は以下とします。
 * 
 * mainメソッドを持ち、ストリーム、ラムダ式、メソッド参照を盛り込んだクラス
 * 
 * 1. 未完了のタスクの個数を表示 
 * 2. 未完了のタスク一覧を日時の昇順に並べて表示 具体的な実行結果の表示は以下となります。
 * 
 * 未完了のタスクの個数は3 【未完了のタスクを昇順に並び替えて一覧表示】 
 * 2021-08-10 散髪に行く 
 * 2021-09-15 ○○社面接
 * 2021-11-09 スクールの課題を解く
 * 
 * ストリーム、ラムダ式、メソッド参照なし 
 * List<Task> filtered = new ArrayList<Task>() ;
 *   for(Task task: list) { 
 *     if(task.isDone() == false) { 
 *       filtered.add(task);
 *     } 
 *   }
 *   System.out.println("未完了のタスクの個数は"+ filtered.size());
 *   System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】"); 
 *   Collections.sort(filtered);
 *   for(Task ta : filtered) { 
 *     System.out.println(ta);
 *   }
 */
