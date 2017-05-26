package com.minyaziutils.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

import com.minyaziutils.LogUtil;
import com.minyaziutils.PlatformException;

/**
 * 经典递归算法：汉诺塔问题<br>
 * 
 * @author minyazi
 */
public class TowerOfHanoi {
	
	private int step; // 移动步数
	private Map<Integer, Integer> steps = new LinkedHashMap<Integer, Integer>(); // 各个圆盘的移动步数
	
	public TowerOfHanoi() {
		
	}
	
	public int getStep() {
		return step;
	}

	public Map<Integer, Integer> getSteps() {
		for (int i : steps.keySet()) {
			LogUtil.info("disk " + i + " move " + steps.get(i) + " times.");
		}
		return steps;
	}

	/**
	 * 算法实现<br>
	 * 
	 * @param diskQuantity 圆盘的数量
	 * @param positionA 位置A（起点）
	 * @param positionB 位置B（辅助点）
	 * @param positionC 位置C（终点）
	 */
	public void move(int diskQuantity, String positionA, String positionB, String positionC) {
		if (diskQuantity < 1) {
			PlatformException pe = new PlatformException("圆盘的数量必须为正整数");
			LogUtil.exception(pe);
			throw pe;
		}
		if (diskQuantity == 1) {
			move(1, positionA, positionC);
		} else {
			move(diskQuantity -1, positionA, positionC, positionB);
			move(diskQuantity, positionA, positionC);
			move(diskQuantity -1, positionB, positionA, positionC);
		}
	}
	
	/**
	 * 移动圆盘<br>
	 * 
	 * @param moveDisk 被移动的圆盘的编号
	 * @param fromPosition 移动之前的位置
	 * @param toPosition 移动之后的位置
	 */
	public void move(int moveDisk, String fromPosition, String toPosition) {
		this.step++;
		if (steps.get(moveDisk) == null) {
			steps.put(moveDisk, 1);
		} else {
			steps.put(moveDisk, steps.get(moveDisk) + 1);
		}
		LogUtil.info(this.step + ".move disk " + moveDisk + " from " + fromPosition + " to " + toPosition + ".");
	}
	
	public static void main(String[] args) {
		TowerOfHanoi hanoi = new TowerOfHanoi();
		hanoi.move(10, "A", "B", "C");
		hanoi.getSteps();
	}

}
