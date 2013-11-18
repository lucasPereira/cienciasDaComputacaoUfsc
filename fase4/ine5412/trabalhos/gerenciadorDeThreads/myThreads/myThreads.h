/*
 * MyThreads.h
 *
 *  Created on: Oct 25, 2011
 *      Author: chrystian
 */

#ifndef MY_THREADS_H_
#define MY_THREADS_H_

#include <cstdlib>
#include <ucontext.h>
#include <iostream>
#include <queue>
#include <signal.h>
#include <unistd.h>
#include <sys/time.h>



using namespace std;

const int MAX_THREADS = 10;
const int STACK_SIZE = 1024 * 1024;

const int LOW_PRIORITY = 9;
const int NORMAL_PRIORITY = 5;
const int HIGH_PRIORITY = 0;

// API MyThreads
int MT_init();
int MT_create(void(*func)(), int arg, int pri);
int MT_join(int idt, int *result);
void MT_exit(int status);
void MT_yield();
int MT_gettid(void);
void MT_exec();

#endif /* MY_THREADS_H_ */
